/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.herlina.sekolahhibernateprimefacescrud.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.herlina.sekolahhibernateprimefacescrud.dao.SiswaDAO;
import org.herlina.sekolahhibernateprimefacescrud.entity.Siswa;

/**
 *
 * @author Herlina
 */
@ManagedBean
@SessionScoped
public class SiswaController{

    
    Siswa siswa;
    List<Siswa> siswaList;
    private String searchBy;
    private String searchValue;
    private SiswaDAO dataAccess;
    
    /**
     * Creates a new instance of SiswaController
     */
    public SiswaController() {
        
     siswaList = new ArrayList<Siswa>();
     siswa = new Siswa();
     dataAccess = new SiswaDAO() {

         @Override
         public void insert(Object obj) {
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }

         @Override
         public void update(Object obj) {
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
     };
     siswaList = dataAccess.getAll();
     
    }
    
    public String displayAll(){
        siswaList = dataAccess.getAll();
        return "List";
    }
    
    public String searchSiswa(){
        siswaList = dataAccess.search(this.searchBy, this.searchValue);
        return "siswa.xhtml";
    }
    
    public String addSiswa(){
        dataAccess.insert(siswa);
        //FacesMessage message = new FacesMessage("Data berhasil ditambahkan");
        //message.setSeverity((FacesMessage.SEVERITY_INFO));
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Data berhasil ditambahkan", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        siswaList = dataAccess.getAll();
        return "siswa.xhtml";
    }
    
     public String updateSiswa() {
        dataAccess.update(siswa);
        FacesMessage message = new FacesMessage("Data berhasil diubah");
        message.setSeverity((FacesMessage.SEVERITY_INFO));
        FacesContext.getCurrentInstance().addMessage(null, message);
        siswaList = dataAccess.getAll();
        return "siswa.xhtml";
    }
     
     public String deleteSiswa() {
        dataAccess.delete(siswa.getId());
        FacesMessage message = new FacesMessage("Data berhasil dihapus");
        message.setSeverity((FacesMessage.SEVERITY_INFO));
        FacesContext.getCurrentInstance().addMessage(null, message);
        siswaList = dataAccess.getAll();
        return "siswa.xhtml";
    }
     
      public Siswa getSiswa() {
        return siswa;
    }
      
      public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }
      
      public List getSiswaList() {
        return siswaList;
    }
    
    public void setSiswaList(List siswaList) {
        this.siswaList = siswaList;
    }
    
    public SiswaDAO getDataAccess() {
        return dataAccess;
    }
    
    public void setDataAccess(SiswaDAO dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public String getSearchBy() {
        return searchBy;
    }
    
    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }
    
    public String getSearchValue() {
        return searchValue;
    }
    
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    // method untuk handling navigasi ke halaman index.xhtml
    public String moveToHome() {
        return "index.xhtml";
    }   
}
