package ConnData;

public class DoanVien
{
    private  int MaDV ;
    private String Ho_Va_Ten;
    private int Tuoi,Gioi_Tinh;
    private String Chi_Doan;
    private float Diem_Phong_Trao;
    public DoanVien(){}
    public DoanVien(int MaDV, String Ho_Va_Ten, int Tuoi, int Gioi_Tinh, String Chi_Doan, float Diem_Phong_Trao) {
        this.MaDV = MaDV;
        this.Ho_Va_Ten = Ho_Va_Ten;
        this.Tuoi = Tuoi;
        this.Gioi_Tinh = Gioi_Tinh;
        this.Chi_Doan = Chi_Doan;
        this.Diem_Phong_Trao = Diem_Phong_Trao;

    }
    public void setHo_Va_Ten(String Ho_Va_Ten) {
        this.Ho_Va_Ten=Ho_Va_Ten;
    }
    public void setMaDV(int MaDV) {
        this.MaDV=MaDV;
    }
    public void setTuoi(int Tuoi) {
        this.Tuoi=Tuoi;
    }
    public void setGioi_Tinh(int Gioi_Tinh) {
        this.Gioi_Tinh=Gioi_Tinh;
    }
    public void setChi_Doan(String Chi_Doan) {
        this.Chi_Doan=Chi_Doan;
    }
    public void setDiem_Phong_Trao(float Diem_Phong_Trao) {
        this.Diem_Phong_Trao=Diem_Phong_Trao;
    }
    public String getHo_Va_Ten() {
        return Ho_Va_Ten;
    }
    public int getTuoi() {
        return Tuoi;
    }
    public int getGioi_Tinh() {
        return Gioi_Tinh;
    }
    public String getChi_Doan() {
        return Chi_Doan;
    }
    public float getDiem_Phong_Trao() {
        return Diem_Phong_Trao;
    }
    public int getMaDV() {
        return MaDV;
    }




}



