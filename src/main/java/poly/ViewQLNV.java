package poly;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class ViewQLNV {
    private JFrame mainFrame;
    private JFrame announFrame;

    private Timer timer;
    private int hours = 0, minutes = 0, seconds = 0;

    private JLabel headerLabel;
    private JLabel timeLabel;
    private JLabel labelMaNV;
    private JLabel labelTenNV;
    private JLabel sexLabel;
    private JLabel seniorityLabel;
    private JLabel monthsLabel;
    private JLabel announLabel;

    private JPanel headerPanel;
    private JPanel controPanel;
    private JScrollPane srollPane;

    private JTextField fieldMaNV;
    private JTextField fieldTenNV;

    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private ButtonGroup sexButtonGroup;

    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton okButton;

    @SuppressWarnings("rawtypes")
    private JComboBox seniorityBox;

    private GridBagConstraints gbcHeader;
    private GridBagConstraints gbcControl;

    private JTable tableNV;

    private List<NhanVien> nhanViens;

    private DefaultTableModel model;

    private int selectedRow = -1;

    public void headerLabel_timeLabel() {
        // Label
        headerLabel = new JLabel("QUAN LI NHAN VIEN");
        headerLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        timeLabel = new JLabel("00:00:00");
        timeLabel.setForeground(new Color(255, 0, 0));
        time();
        // Panel
        headerPanel = new JPanel(new GridBagLayout());
        gbcHeader = new GridBagConstraints();
        headerPanel.setBounds(0, 0, 450, 50);
        gbcHeader.gridx = 0;
        gbcHeader.gridy = 0;
        gbcHeader.insets = new Insets(0, 190, 0, 60);
        headerPanel.add(headerLabel, gbcHeader);
        gbcHeader.gridx = 1;
        gbcHeader.gridy = 0;
        gbcHeader.insets = new Insets(-5, 0, 0, 50);
        headerPanel.add(timeLabel, gbcHeader);
    }

    public void field_MaNV_TenNV() {
        // maNV
        labelMaNV = new JLabel("Ma nhan vien");
        labelMaNV.setPreferredSize(new Dimension(90, 20));

        fieldMaNV = new JTextField();
        fieldMaNV.setColumns(25);
        fieldMaNV.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1), // Outer border
                BorderFactory.createEmptyBorder(1, 1, 1, 1) // Inner padding
        ));
        // fieldMaNV.setFont(new Font("Calibri", Font.PLAIN, 13));
        gbcControl.gridx = 0;
        gbcControl.gridy = 0;
        gbcControl.insets = new Insets(0, -30, 0, 10);
        controPanel.add(labelMaNV, gbcControl);
        gbcControl.gridx = 1;
        gbcControl.gridy = 0;
        gbcControl.insets = new Insets(0, 0, 0, 0);
        controPanel.add(fieldMaNV, gbcControl);

        // fieldMaNV.addActionListener(this);
        // TenNV
        labelTenNV = new JLabel("Ten nhan vien");
        labelTenNV.setPreferredSize(new Dimension(90, 20));

        fieldTenNV = new JTextField();
        fieldTenNV.setColumns(25);
        fieldTenNV.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        gbcControl.gridx = 0;
        gbcControl.gridy = 1;
        gbcControl.insets = new Insets(15, -30, 0, 10);
        controPanel.add(labelTenNV, gbcControl);
        gbcControl.gridx = 1;
        gbcControl.gridy = 1;
        gbcControl.insets = new Insets(15, 0, 0, 0);
        controPanel.add(fieldTenNV, gbcControl);

    }

    public NhanVien sex_seniority_func() {
        NhanVien nv = new NhanVien();
        // label
        sexLabel = new JLabel("Gioi tinh");
        sexLabel.setPreferredSize(new Dimension(90, 20));
        gbcControl.gridx = 0;
        gbcControl.gridy = 2;
        gbcControl.insets = new Insets(15, -37, 0, 0);
        controPanel.add(sexLabel, gbcControl);

        maleButton = new JRadioButton("Nam");
        maleButton.setFocusable(false);
        gbcControl.gridx = 1;
        gbcControl.gridy = 2;
        gbcControl.insets = new Insets(15, -210, 0, 0);
        controPanel.add(maleButton, gbcControl);

        femaleButton = new JRadioButton("Nu");
        femaleButton.setFocusable(false);
        gbcControl.gridx = 2;
        gbcControl.gridy = 2;
        gbcControl.insets = new Insets(15, -300, 0, 0);
        controPanel.add(femaleButton, gbcControl);

        sexButtonGroup = new ButtonGroup();
        sexButtonGroup.add(maleButton);
        sexButtonGroup.add(femaleButton);
        // tham nien
        seniorityLabel = new JLabel("Tham nien");
        seniorityLabel.setPreferredSize(new Dimension(90, 20));

        monthsLabel = new JLabel("Thang");
        seniorityLabel.setPreferredSize(new Dimension(90, 20));

        Integer[] listThamNien = new Integer[100];
        for (int i = 0; i < 100; i++) {
            listThamNien[i] = i + 1;
        }
        seniorityBox = new JComboBox<Integer>(listThamNien);
        seniorityBox.setEditable(false);
        seniorityBox.setPreferredSize(new Dimension(120, 20));
        seniorityBox.setBackground(Color.LIGHT_GRAY);
        

        gbcControl.gridx = 0;
        gbcControl.gridy = 3;
        gbcControl.insets = new Insets(15, -38, 0, 0);
        controPanel.add(seniorityLabel, gbcControl);

        gbcControl.gridx = 1;
        gbcControl.gridy = 3;
        gbcControl.insets = new Insets(15, -133, 0, 0);
        controPanel.add(seniorityBox, gbcControl);

        gbcControl.gridx = 2;
        gbcControl.gridy = 3;
        gbcControl.insets = new Insets(15, -200, 0, 0);
        controPanel.add(monthsLabel, gbcControl);
        // button
        addButton = new javax.swing.JButton("Them");
        addButton.setFocusable(false);
        addButton.setBackground(Color.LIGHT_GRAY);
        gbcControl.gridx = 0;
        gbcControl.gridy = 4;
        gbcControl.insets = new Insets(15, -60, 0, 0);
        controPanel.add(addButton, gbcControl);

        editButton = new JButton("Sua");
        editButton.setFocusable(false);
        editButton.setBackground(Color.LIGHT_GRAY);
        gbcControl.gridx = 1;
        gbcControl.gridy = 4;
        gbcControl.insets = new Insets(15, -200, 0, 0);
        controPanel.add(editButton, gbcControl);

        deleteButton = new JButton("Xoa");
        deleteButton.setFocusable(false);
        deleteButton.setBackground(Color.LIGHT_GRAY);
        gbcControl.gridx = 2;
        gbcControl.gridy = 4;
        gbcControl.insets = new Insets(15, -280, 0, 0);
        controPanel.add(deleteButton, gbcControl);

        saveButton = new JButton("Ghi File");
        saveButton.setFocusable(false);
        saveButton.setBackground(Color.LIGHT_GRAY);
        gbcControl.gridx = 3;
        gbcControl.gridy = 4;
        gbcControl.insets = new Insets(15, -85, 0, 0);
        controPanel.add(saveButton, gbcControl);
        return nv;
    }

    public void listNV() {
        // table
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableNV = new JTable(model);
        model.addColumn("MaNV");
        model.addColumn("TenNV");
        model.addColumn("Gioi tinh");
        model.addColumn("Tham nien");
        model.addColumn("Thuong");

        int[] columnWidhts = { 90, 160, 80, 100, 120 };
        for (int i = 0; i < 5; i++) {
            TableColumn column = tableNV.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidhts[i]);
        }
        tableNV.setRowHeight(20);
        tableNV.getTableHeader().setReorderingAllowed(false);
        // panel
        srollPane = new JScrollPane(tableNV);
        srollPane.setBounds(30, 260, 440, 290);
    }

    public void announcement() {
        announLabel = new JLabel("Vui long chon ban ghi !");
        announLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        announLabel.setForeground(Color.RED);

        okButton = new JButton("OK");
        okButton.setBounds(100, 65, 100, 65);
        okButton.setFocusable(false);
        okButton.setBackground(Color.LIGHT_GRAY);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == okButton) {
                    announFrame.setVisible(false);
                }
            }

        });

        announFrame = new JFrame();
        announFrame.setSize(250, 150);
        announFrame.setLayout(new FlowLayout());
        announFrame.setLocationRelativeTo(null);
        // announFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        announFrame.setVisible(true);
        announFrame.getContentPane().add(announLabel);
        announFrame.getContentPane().add(okButton);
    }

    public void addActions() {
        maleButton.setActionCommand("1");
        femaleButton.setActionCommand("0");

        tableNV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = tableNV.getSelectedRow();
                if (selectedRow != -1) {
                    fieldMaNV.setText(nhanViens.get(selectedRow).getMaNV());
                    fieldTenNV.setText(nhanViens.get(selectedRow).getTenNV());
                    if (nhanViens.get(selectedRow).isGioiTinh()) {
                        maleButton.setSelected(true);
                    } else {
                        femaleButton.setSelected(true);
                    }
                    seniorityBox.setSelectedItem(nhanViens.get(selectedRow).getThamNien());
                }
            }

        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addButton) {
                    if (!fieldMaNV.getText().isEmpty() && !fieldTenNV.getText().isEmpty()
                            && sexButtonGroup.getSelection() != null) {
                        NhanVien nv = new NhanVien(
                                fieldMaNV.getText(), fieldTenNV.getText(),
                                sexButtonGroup.getSelection().getActionCommand().equals("1") ? true : false,
                                (Integer) (seniorityBox.getSelectedItem()));
                        model.addRow(new Object[] {
                                nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh(),
                                nv.getThamNien(), nv.tinhThuong(nv.getThamNien())
                        });
                        fieldMaNV.setText("");
                        fieldTenNV.setText("");
                        sexButtonGroup.clearSelection();
                        seniorityBox.setSelectedItem(1);
                        nhanViens.add(nv);

                    } else {

                    }
                }
            }

        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == editButton) {
                    selectedRow = tableNV.getSelectedRow();
                    if (selectedRow != -1) {
                        NhanVien updateNV = new NhanVien(
                                fieldMaNV.getText(), fieldTenNV.getText(),
                                sexButtonGroup.getSelection().getActionCommand().equals("1") ? true : false,
                                (Integer) seniorityBox.getSelectedItem());
                        nhanViens.set(selectedRow, updateNV);
                        Object[] obj = new Object[] {
                                updateNV.getMaNV(), updateNV.getTenNV(), updateNV.isGioiTinh(),
                                updateNV.getThamNien(), updateNV.tinhThuong(updateNV.getThamNien())
                        };
                        for (int i = 0; i < 5; i++) {
                            model.setValueAt(obj[i], selectedRow, i);
                        }
                    } else {
                        announcement();
                    }
                }

            }

        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == deleteButton) {
                    selectedRow = tableNV.getSelectedRow();
                    if (selectedRow != -1) {
                        nhanViens.remove(selectedRow);
                        model.removeRow(selectedRow);

                    } else {
                        announcement();
                    }
                }
            }

        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == saveButton) {

                }
            }

        });
    }

    public void prepareGUI() {
        gbcControl = new GridBagConstraints();
        controPanel = new JPanel(new GridBagLayout());
        controPanel.setBounds(0, 50, 500, 200);
        nhanViens = new ArrayList<NhanVien>();

        headerLabel_timeLabel();
        field_MaNV_TenNV();
        sex_seniority_func();
        listNV();
        addActions();

        mainFrame = new JFrame("Quan Li Nhan Vien");
        mainFrame.setSize(500, 600);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(headerPanel);
        mainFrame.add(controPanel);
        mainFrame.add(srollPane);
    }

    public void time() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                updateTime();
            }

        });
        timer.start();
    }

    private void updateTime() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
        }
        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}
