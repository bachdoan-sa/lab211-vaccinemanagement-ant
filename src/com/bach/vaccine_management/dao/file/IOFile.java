/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bach.vaccine_management.dao.file;

import java.util.ArrayList;

/**
 *
 * @author AN515-57
 */
public interface IOFile {
    public ArrayList<Object>  readFile();
    public boolean writeFile();
}
