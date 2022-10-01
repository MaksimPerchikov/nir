package ru.nir.dto;

public class CustomerTaskDTO {

    private String nameTask;
    private String text;

    public String getNameTask() {
        return nameTask;
    }

    public String getText() {
        return text;
    }


    public void setNameTask(String nameTask){
        this.nameTask = nameTask;
    }

    public void setText(String text) {
        this.text = text;
    }
}
