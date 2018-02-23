/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.herlina.sekolahhibernateprimefacescrud.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Herlina
 */
@Named(value = "indexController")
@SessionScoped
public class IndexController implements Serializable {

    /**
     * Creates a new instance of IndexController
     */
    public IndexController(){
        
    }
    
    //Method untuk navigasi ke halaman web siswa.xhtml
    
    public String moveToPageSiswa(){
        return "siswa.xhtml";
                
    }
   
}
