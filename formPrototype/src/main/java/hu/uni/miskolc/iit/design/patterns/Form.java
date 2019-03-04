package hu.uni.miskolc.iit.design.patterns;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;

public class Form {

    private File formTemplate;
    private Collection<Field> fields;

    protected Form(File formTemplate, Collection<Field> fields) {
        this.formTemplate = formTemplate;
        this.fields = fields;
    }

    protected File getFormTemplate() {
        return formTemplate;
    }

    protected Collection<Field> getFields() {
        return fields;
    }

    public Collection<String> getFieldKeys(){
        Collection<String> result = new HashSet<>();
        for(Field field : fields){
            result.add(field.getName());
        }
        return result;
    }

    public void setField(String key, String value){
        for(Field field : fields){
            if(field.getName().equals(key)){
                field.setValue(value);
            }
        }
    }

    public File export2PDF(String filename) throws TypeMismatchException {
        for(Field field : fields){
            field.checkField();
        }
        //TODO: PDF generation logic.
        return null;
    }


}
