package hu.uni.miskolc.iit.design.patterns;

import java.util.regex.Pattern;

public class Field {

    public enum Type{
        STRING("\\w*"), NUMBER("\\d*");

        private Pattern pattern;
        Type(String regex){
            this.pattern = Pattern.compile(regex);
        }

        private boolean match(String value){
            return pattern.matcher(value).matches();
        }
    }

    private String name;
    private String value;
    private Type type;

    public Field(String name, String value, Type type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    protected void checkField() throws TypeMismatchException{
        if(value == null || type.match(value) == false){
            throw  new TypeMismatchException();
        }
    }
}
