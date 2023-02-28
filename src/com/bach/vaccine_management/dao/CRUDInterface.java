/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bach.vaccine_management.dao;

import java.util.ArrayList;

/**
 *
 * @author AN515-57
 */
public interface CRUDInterface {
    public boolean readAllList(ArrayList<Class> arrayList);
    public boolean createObjectInList(Object object, ArrayList<Class> arrayList);
    public boolean updateObjectInList(Object object, ArrayList<Class> arrayList);
    public boolean deleteObjectInList(Object object, ArrayList<Class> arrayList);
    
}
