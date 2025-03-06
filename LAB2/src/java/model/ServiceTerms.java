/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;


/**
 *
 * @author Acer Nitro Tiger
 */
public class ServiceTerms {
    public int term_id,service_id,max_term_months;
    public String term_name,description,contract_terms,status,service_name;
    public double early_payment_penalty,interest_rate,min_payment,min_deposit;
    public Date created_at;

    public ServiceTerms() {
    }

    public ServiceTerms(int term_id, int service_id, int max_term_months, String term_name, String description, String contract_terms, String status, String service_name, double early_payment_penalty, double interest_rate, double min_payment, double min_deposit, Date created_at) {
        this.term_id = term_id;
        this.service_id = service_id;
        this.max_term_months = max_term_months;
        this.term_name = term_name;
        this.description = description;
        this.contract_terms = contract_terms;
        this.status = status;
        this.service_name = service_name;
        this.early_payment_penalty = early_payment_penalty;
        this.interest_rate = interest_rate;
        this.min_payment = min_payment;
        this.min_deposit = min_deposit;
        this.created_at = created_at;
    }
    
    //for add
    public ServiceTerms(int service_id, int max_term_months, String term_name, String description, String contract_terms, double early_payment_penalty, double interest_rate, double min_payment, double min_deposit) {
        this.service_id = service_id;
        this.max_term_months = max_term_months;
        this.term_name = term_name;
        this.description = description;
        this.contract_terms = contract_terms;
        this.early_payment_penalty = early_payment_penalty;
        this.interest_rate = interest_rate;
        this.min_payment = min_payment;
        this.min_deposit = min_deposit;
    }

    //for update

    public ServiceTerms(int term_id, int max_term_months, String term_name, String description, String contract_terms, String status, double early_payment_penalty, double interest_rate, double min_payment, double min_deposit) {
        this.term_id = term_id;
        this.max_term_months = max_term_months;
        this.term_name = term_name;
        this.description = description;
        this.contract_terms = contract_terms;
        this.status = status;
        this.early_payment_penalty = early_payment_penalty;
        this.interest_rate = interest_rate;
        this.min_payment = min_payment;
        this.min_deposit = min_deposit;
    }
    

   
    

    public int getTerm_id() {
        return term_id;
    }

    public void setTerm_id(int term_id) {
        this.term_id = term_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getMax_term_months() {
        return max_term_months;
    }

    public void setMax_term_months(int max_term_months) {
        this.max_term_months = max_term_months;
    }

    public String getTerm_name() {
        return term_name;
    }

    public void setTerm_name(String term_name) {
        this.term_name = term_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContract_terms() {
        return contract_terms;
    }

    public void setContract_terms(String contract_terms) {
        this.contract_terms = contract_terms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public double getEarly_payment_penalty() {
        return early_payment_penalty;
    }

    public void setEarly_payment_penalty(double early_payment_penalty) {
        this.early_payment_penalty = early_payment_penalty;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public double getMin_payment() {
        return min_payment;
    }

    public void setMin_payment(double min_payment) {
        this.min_payment = min_payment;
    }

    public double getMin_deposit() {
        return min_deposit;
    }

    public void setMin_deposit(double min_deposit) {
        this.min_deposit = min_deposit;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

   
    @Override
    public String toString() {
        return "ServiceTerms{" + "term_id=" + term_id + ", service_id=" + service_id + ", max_term_months=" + max_term_months + ", term_name=" + term_name + ", description=" + description + ", contract_terms=" + contract_terms + ", status=" + status + ", service_name=" + service_name + ", early_payment_penalty=" + early_payment_penalty + ", interest_rate=" + interest_rate + ", min_payment=" + min_payment + ", min_deposit=" + min_deposit + ", created_at=" + created_at + '}';
    }

    
    
}
