package za.ac.cput.domain;

import java.util.Objects;

/*
    Invoice.java
    Entity for the Invoice
    Author: Shina Kara (219333181)
    Date: 4 August 2022
*/
public class Invoice {
    private String invoiceNum;
    private Double invoiceAmount;
    private String invoiceType;
    private String invoiceDate;

    public Invoice(Builder builder) {
        this.invoiceNum = builder.invoiceNum;
        this.invoiceType = builder.invoiceType;
        this.invoiceAmount = builder.invoiceAmount;
        this.invoiceDate = builder.invoiceDate;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice that = (Invoice) o;
        return invoiceNum == that.invoiceNum && invoiceType.equals(that.invoiceType) && invoiceAmount.equals(that.invoiceAmount) && invoiceDate.equals(that.invoiceDate);
    }

    @Override

    public int hashCode() {
        return Objects.hash(invoiceNum, invoiceAmount, invoiceType, invoiceDate);
    }

    public static class Builder {
        private String invoiceNum;
        private Double invoiceAmount;
        private String invoiceType;

        private String invoiceDate;


        public Builder invoiceNum(String invoiceNum) {
            this.invoiceNum = invoiceNum;
            return this;
        }

        public Builder invoiceAmount(Double invoiceAmount) {
            this.invoiceAmount = invoiceAmount;
            return this;
        }

        public Builder invoiceType(String invoiceType) {
            this.invoiceType = invoiceType;
            return this;
        }

        public Builder invoiceDate(String invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder copy(Invoice invoice) {
            this.invoiceNum = invoice.invoiceNum;
            this.invoiceAmount = invoice.invoiceAmount;
            this.invoiceType = invoice.invoiceType;
            this.invoiceDate = invoice.invoiceDate;
            return this;
        }
        public Invoice build() {
            return new Invoice(this);

        }
    }
    }
