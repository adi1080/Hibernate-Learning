package com.cjc.ims.app.servicei;

import com.cjc.ims.app.serviceimpl.WrongInputException;

public interface CJC {
    public void addCourse()throws WrongInputException;
    public void viewCourse();
    public void addFaculty() throws WrongInputException;
    public void viewFaculty();
    public void addBatch()throws WrongInputException;
    public void viewBatch();
    public void addStudent()throws WrongInputException;
    public void viewStudent();
    
}
