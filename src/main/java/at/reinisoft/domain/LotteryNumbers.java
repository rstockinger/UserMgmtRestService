package at.reinisoft.domain;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by stocki on 24.01.15.
 */
@Entity
@Table(name = "LOTTERY")
@SequenceGenerator(name = AbstractEntity.SEQ_ID, sequenceName = "SEQ_LOTTERY", allocationSize = 1)
public class LotteryNumbers extends AbstractEntity {

    private String numberOne;
    private String numberTwo;
    private String numberThree;
    private String numberFour;
    private String numberFive;
    private String numberSix;
    private String numberExtra;
    private String drawDate;

    public LotteryNumbers() {
    }

    public LotteryNumbers(String[] fields) {
        this.numberOne = fields[0];
        this.numberTwo = fields[1];
        this.numberThree = fields[2];
        this.numberFour = fields[3];
        this.numberFive = fields[4];
        this.numberSix = fields[5];
        this.numberExtra = fields[6];
        this.drawDate = fields[7];
    }

    public LotteryNumbers(String numberOne, String numberTwo, String numberThree, String numberFour, String numberFive, String numberSix, String numberExtra, String drawDate) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.numberThree = numberThree;
        this.numberFour = numberFour;
        this.numberFive = numberFive;
        this.numberSix = numberSix;
        this.numberExtra = numberExtra;
        this.drawDate = drawDate;
    }

    public String getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(String numberOne) {
        this.numberOne = numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(String numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getNumberThree() {
        return numberThree;
    }

    public void setNumberThree(String numberThree) {
        this.numberThree = numberThree;
    }

    public String getNumberFour() {
        return numberFour;
    }

    public void setNumberFour(String numberFour) {
        this.numberFour = numberFour;
    }

    public String getNumberFive() {
        return numberFive;
    }

    public void setNumberFive(String numberFive) {
        this.numberFive = numberFive;
    }

    public String getNumberSix() {
        return numberSix;
    }

    public void setNumberSix(String numberSix) {
        this.numberSix = numberSix;
    }

    public String getNumberExtra() {
        return numberExtra;
    }

    public void setNumberExtra(String numberExtra) {
        this.numberExtra = numberExtra;
    }

    public String getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(String drawDate) {
        this.drawDate = drawDate;
    }

    @Override
    public String toString() {
        return "LotteryNumbers{" +
                "numberOne='" + numberOne + '\'' +
                ", numberTwo='" + numberTwo + '\'' +
                ", numberThree='" + numberThree + '\'' +
                ", numberFour='" + numberFour + '\'' +
                ", numberFive='" + numberFive + '\'' +
                ", numberSix='" + numberSix + '\'' +
                ", numberExtra='" + numberExtra + '\'' +
                ", drawDate='" + drawDate + '\'' +
                '}';
    }
}
