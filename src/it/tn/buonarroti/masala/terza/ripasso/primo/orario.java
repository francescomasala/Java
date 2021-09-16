package it.tn.buonarroti.masala.terza.ripasso.primo;

public class orario {
    private Integer SS;
    private Integer MM;
    private Integer HH;

    public orario(){
        this.SS = 00;
        this.MM = 00;
        this.HH = 00;

    }

    public orario(Integer HH, Integer MM, Integer SS){
        this.SS = SS;
        this.MM = MM;
        this.HH = HH;
    }

    public void AddSS(Integer New_Sec){

        this.SS = this.SS + New_Sec;

    }

    public void AddMM(Integer New_Min){

        this.MM = this.MM + New_Min;

    }

    public void AddHH(Integer New_Hour){

        this.HH = this.HH + New_Hour;

    }

    public void RmSS(Integer New_Sec){

        this.SS = this.SS - New_Sec;

    }

    public void RmMM(Integer New_Min){

        this.MM = this.MM - New_Min;

    }

    public void RmHH(Integer New_Hour){

        this.HH = this.HH - New_Hour;

    }

    public Integer ToSecFromMidnight(){
        Integer result = 0;

        result = this.HH * 60;
        result = result + (this.MM * 60);
        result = result + this.SS;

        return result;
    }

    public Integer ToMinFromMidnight(){
        Integer result;

        result = (this.HH * 60);
        result = result + this.MM;

        if (this.SS >= 30) {
            result = result + 1;
        }

        return result;

    }

    public Integer ToHourFromMidnight(){

        Integer result;

        result = this.HH;

        if (this.MM >= 30) {
            result = result + 1;
        }

        return result;
    }

    public Integer ToSecToMidnight(){
        Integer result;

        result = this.ToMinToMidnight() * 60;
        result = result + (60 - this.SS);

        return result;
    }

    public Integer ToMinToMidnight(){
        Integer result;

        result = this.ToHourToMidnight() * 60;
        result = result + (60 - this.MM);

        return result;
    }

    public Integer ToHourToMidnight(){
        Integer result;

        result = 24 - this.HH;

        return result;
    }

    private void SecondsToTime(Integer sec){
        if (sec > 86400){
            sec -= 86400;
        }

        this.HH = sec / 3600;
        this.MM = sec / 60;
        this.SS = sec %60;
    }

    @Override
    public String toString(){
        String result = this.HH + ":" + this.MM + ":" + this.SS;
        return result;
    }
}
