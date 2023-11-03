package ConnData;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jframDoanVien  extends JFrame
{
    private JPanel contentPane;
    private JTextField txtHo_Va_Ten;
    private JTextField txtTuoi;
    private JTextField txtDiem_Phong_Trao;
    private JTextField txtChi_Doan;
    private static JTable table;

    public static void main(String[] args)
    {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    jframDoanVien frame = new jframDoanVien();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public jframDoanVien() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 985, 687);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Quản Lí Đoàn Viên");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(320, 51, 395, 89);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Họ Và Tên");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(65, 171, 93, 36);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Tuổi");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(65, 239, 93, 36);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Giới Tính");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setBounds(65, 309, 93, 36);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Chi Đoàn");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_3.setBounds(65, 377, 93, 36);
        contentPane.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Điểm");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_4.setBounds(65, 449, 93, 36);
        contentPane.add(lblNewLabel_1_4);

        txtHo_Va_Ten = new JTextField();
        txtHo_Va_Ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtHo_Va_Ten.setBounds(149, 171, 200, 36);
        contentPane.add(txtHo_Va_Ten);
        txtHo_Va_Ten.setColumns(10);

       txtTuoi = new JTextField();
        txtTuoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTuoi.setColumns(10);
        txtTuoi.setBounds(149, 239, 200, 36);
        contentPane.add(txtTuoi);

        txtDiem_Phong_Trao = new JTextField();
        txtDiem_Phong_Trao.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtDiem_Phong_Trao.setColumns(10);
        txtDiem_Phong_Trao.setBounds(149, 450, 200, 36);
        contentPane.add(txtDiem_Phong_Trao);

        txtChi_Doan = new JTextField();
        txtChi_Doan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtChi_Doan.setColumns(10);
        txtChi_Doan.setBounds(149, 377, 200, 36);
        contentPane.add(txtChi_Doan);

        JComboBox gioitinh = new JComboBox();
        gioitinh.setFont(new Font("Tahoma", Font.BOLD, 14));
        gioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
        gioitinh.setBounds(149, 309, 109, 36);
        contentPane.add(gioitinh);

        JButton btnNewButton = new JButton("Lưu");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoanVien dv=new DoanVien();
                dv.setHo_Va_Ten(txtHo_Va_Ten.getText());
                dv.setTuoi(Integer.parseInt(txtTuoi.getText()));
                dv.setGioi_Tinh(gioitinh.getSelectedIndex());
                dv.setChi_Doan(txtChi_Doan.getText());
                dv.setDiem_Phong_Trao(Float.parseFloat(txtDiem_Phong_Trao.getText()));
                ConnDatadv.insert(dv);
                JOptionPane.showMessageDialog(null, " Lưu Thành Công. ");
                showData(ConnDatadv.findAll());
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(41, 521, 132, 51);
        contentPane.add(btnNewButton);

        JButton btnDelete = new JButton("Xóa ");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoanVien dv=new DoanVien();
                dv.setHo_Va_Ten(txtHo_Va_Ten.getText());
                ConnDatadv.delete(dv);
                showData(ConnDatadv.findAll());
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDelete.setBounds(217, 521, 132, 51);
        contentPane.add(btnDelete);

        JButton btnFind = new JButton("Tìm Kiếm");
        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               DoanVien dv =new DoanVien();
                dv.setHo_Va_Ten(txtHo_Va_Ten.getText());
                showData(ConnDatadv.findByName(dv));
            }
        });
        btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnFind.setBounds(397, 521, 132, 51);
        contentPane.add(btnFind);

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtHo_Va_Ten.setText("");
                txtTuoi.setText("");
                txtChi_Doan.setText("");
                txtDiem_Phong_Trao.setText("");
            }
        });
        btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRefresh.setBounds(397, 434, 132, 51);
        contentPane.add(btnRefresh);

        JButton btnUpdate = new JButton("ManagerChat");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoanVien dv=new DoanVien();
                dv.setHo_Va_Ten(txtHo_Va_Ten.getText());
                dv.setTuoi(Integer.parseInt(txtTuoi.getText()));
                dv.setGioi_Tinh(gioitinh.getSelectedIndex());
                dv.setChi_Doan(txtChi_Doan.getText());
                dv.setDiem_Phong_Trao(Float.parseFloat(txtDiem_Phong_Trao.getText()));
                ConnDatadv.Update(dv);
                JOptionPane.showMessageDialog(null, "Save Success! ");
                showData(ConnDatadv.findAll());
            }
        });
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnUpdate.setBounds(566, 521, 132, 51);
        contentPane.add(btnUpdate);


        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerChatter obj = new ManagerChatter();
                obj.setTitle("Mangnager-Chat");
                obj.setVisible(true);





            }
        });

        JButton btnChat = new JButton("ClientChat");
        btnChat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnChat.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnChat.setBounds(735, 521, 132, 51);
        contentPane.add(btnChat);


        btnChat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              ClientChatter obj = new ClientChatter();
                obj.setTitle("client-chat");
                obj.setVisible(true);





            }
        });



        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(397, 171, 572, 239);
        contentPane.add(scrollPane);


        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "MaDV", "Họ Và Tên", "Tuổi", "Giới Tính", "Chi Đoàn", "Điểm"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(0).setMinWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setMinWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setMinWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setMinWidth(100);
        table.getColumnModel().getColumn(5).setMinWidth(50);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        scrollPane.setViewportView(table);
        showData(ConnDatadv.findAll());
    }
    public void showData(List<DoanVien>doanvien) {
        List<DoanVien>listDoanVien=new ArrayList<>();
        listDoanVien=doanvien;
        DefaultTableModel tableModel;
        table.getModel();
        tableModel=(DefaultTableModel)table.getModel();
        tableModel.setRowCount(0);
        listDoanVien.forEach((dv) -> {
            String gender;
            if(dv.getGioi_Tinh()==0) {
                gender="Nam";
                tableModel.addRow(new Object [] {
                    dv.getMaDV(),dv.getHo_Va_Ten(),dv.getTuoi(),
                   gender,dv.getChi_Doan(),dv.getDiem_Phong_Trao()
                });
            } else {gender="Nữ";
                tableModel.addRow(new Object [] {
                       dv.getMaDV(),dv.getHo_Va_Ten(),dv.getTuoi(),
                        gender,dv.getChi_Doan(),dv.getDiem_Phong_Trao()
                });
            }
        });
    }

}
