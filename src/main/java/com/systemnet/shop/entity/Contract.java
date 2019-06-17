package com.systemnet.shop.entity;

import java.util.Date;

public class Contract extends AbstractEntity<Integer> {
    private String ceoName;
    private String ceoLastName;
    private String ceoMiddleName;
    private int contractNumber;
    private Date dateContract;
    private String baseDocument;
    private String legalAdress;
    private String postAdress;
    private int stateRegistrationNumber;
    private int currentRr;
    private String bankName;
    private int bankIdentificationCode;
    private int indivudualTexpayarCode;

    public Contract(String ceoName, String ceoLastName, String ceoMiddleName, int contractNumber, Date dateContract, String baseDocument, String legalAdress, String postAdress, int stateRegistrationNumber, int currentRr, String bankName, int bankIdentificationCode, int indivudualTexpayarCode) {
        this.ceoName = ceoName;
        this.ceoLastName = ceoLastName;
        this.ceoMiddleName = ceoMiddleName;
        this.contractNumber = contractNumber;
        this.dateContract = dateContract;
        this.baseDocument = baseDocument;
        this.legalAdress = legalAdress;
        this.postAdress = postAdress;
        this.stateRegistrationNumber = stateRegistrationNumber;
        this.currentRr = currentRr;
        this.bankName = bankName;
        this.bankIdentificationCode = bankIdentificationCode;
        this.indivudualTexpayarCode = indivudualTexpayarCode;
    }

    public Contract() {
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    public String getCeoLastName() {
        return ceoLastName;
    }

    public void setCeoLastName(String ceoLastName) {
        this.ceoLastName = ceoLastName;
    }

    public String getCeoMiddleName() {
        return ceoMiddleName;
    }

    public void setCeoMiddleName(String ceoMiddleName) {
        this.ceoMiddleName = ceoMiddleName;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getDateContract() {
        return dateContract;
    }

    public void setDateContract(Date dateContract) {
        this.dateContract = dateContract;
    }

    public String getBaseDocument() {
        return baseDocument;
    }

    public void setBaseDocument(String baseDocument) {
        this.baseDocument = baseDocument;
    }

    public String getLegalAdress() {
        return legalAdress;
    }

    public void setLegalAdress(String legalAdress) {
        this.legalAdress = legalAdress;
    }

    public String getPostAdress() {
        return postAdress;
    }

    public void setPostAdress(String postAdress) {
        this.postAdress = postAdress;
    }

    public int getStateRegistrationNumber() {
        return stateRegistrationNumber;
    }

    public void setStateRegistrationNumber(int stateRegistrationNumber) {
        this.stateRegistrationNumber = stateRegistrationNumber;
    }

    public int getCurrentRr() {
        return currentRr;
    }

    public void setCurrentRr(int currentRr) {
        this.currentRr = currentRr;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankIdentificationCode() {
        return bankIdentificationCode;
    }

    public void setBankIdentificationCode(int bankIdentificationCode) {
        this.bankIdentificationCode = bankIdentificationCode;
    }

    public int getIndivudualTexpayarCode() {
        return indivudualTexpayarCode;
    }

    public void setIndivudualTexpayarCode(int indivudualTexpayarCode) {
        this.indivudualTexpayarCode = indivudualTexpayarCode;
    }
}
