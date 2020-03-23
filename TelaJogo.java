package edu.telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class TelaJogo extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private String JogadaFeita = "Esta Jogadaa já foi feita!";
	
	public TelaJogo() {
		button1 = new JButton("");
		button2 = new JButton("");
		button3 = new JButton("");
		button4 = new JButton("");
		button5 = new JButton("");
		button6 = new JButton("");
		button7 = new JButton("");
		button8 = new JButton("");
		button9 = new JButton("");
		lblInformaes = new JLabel("Informações");
		btnNovoJogo = new JButton("Novo Jogo");
		btnSairDoJogo = new JButton("Sair do Jogo");
		btnSobreJogo = new JButton("Sobre o Jogo");
		separator = new JSeparator();
		lblJogadorX = new JLabel("Jogador X");
		lblVitoriasX = new JLabel("Vitórias: " + Vitorias[0]);
		separator_1 = new JSeparator();
		lblJogadorO = new JLabel("Jogador O");
		lblVitoriasO = new JLabel("Vitórias: " + Vitorias[1]);
		separator_2 = new JSeparator();
		lblEmpates = new JLabel("Empates: " + Empates);

		ZerarJogo();
		ConfigBotoes();
		AcoesBotao();

		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Jogo da Velha - Eduardo Assunção");
		setSize(650, 425);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		setVisible(true);
	}

	int Jogador;
	int Empates;
	int[] Vitorias = new int[2];

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JLabel lblInformaes;
	private JButton btnNovoJogo;
	private JButton btnSairDoJogo;
	private JButton btnSobreJogo;
	private JSeparator separator;
	private JLabel lblJogadorX;
	private JLabel lblVitoriasX;
	private JSeparator separator_1;
	private JLabel lblJogadorO;
	private JLabel lblVitoriasO;
	private JSeparator separator_2;
	private JLabel lblEmpates;

	private void Jogadas() {
		Jogador++;
		VerificaResultado();
	}

	/*
	 * O JOGADOR É IDENTIFICADO ATRAVÉS DE UM CONTADOR QUE VAI SOMANDO A CADA JOGADA
	 * 
	 * NUMEROS PARES SÃO DO JOGADOR X - NUMEROS IMPARES SÃO DO JOGADOR O
	 * 
	 * A CADA JOGADA A POSIÇÃO É PREENCHIDA EM UM VETOR E VERIFICAR SE HOUVE EMPATE
	 * OU VENCEDOR
	 * 
	 */
	private String getJogador() {
		String ret;
		if (Jogador % 2 == 0) {
			ret = "X";
		} else {
			ret = "O";
		}
		return ret;
	}

	private void VerificaResultado() {
		/*
		 * Por ser a função mais chamada, coloquei a função atualiza vitórias para estar
		 * sempre atualizado as informações
		 */
		AtualizaVitorias();

		/* FOR PARA VERIFICAR DUAS VEZES, UMA PARA CADA JOGADOR */
		for (int i = 1; i <= 2; i++) {
			String j;
			if (i == 1) {
				j = "X";
			} else {
				j = "O";
			}
			// Linha 1
			if (button1.getText().equals(j) && button2.getText().equals(j) && button3.getText().equals(j)) {
				Venceu(j, i);
				return;
			}
			// Linha 2
			if (button4.getText().equals(j) && button5.getText().equals(j) && button6.getText().equals(j)) {
				Venceu(j, i);
				return;
			}
			// Linha 3
			if (button7.getText().equals(j) && button8.getText().equals(j) && button9.getText().equals(j)) {
				Venceu(j, i);
				return;
			}

			// Coluna 1
			if (button1.getText().equals(j) && button4.getText().equals(j) && button7.getText().equals(j)) {
				Venceu(j, i);
				return;
			}
			// Coluna 2
			if (button2.getText().equals(j) && button5.getText().equals(j) && button8.getText().equals(j)) {
				Venceu(j, i);
				return;
			}
			// Coluna 3
			if (button3.getText().equals(j) && button6.getText().equals(j) && button9.getText().equals(j)) {
				Venceu(j, i);
				return;
			}

			// Cruzada 1
			if (button1.getText().equals(j) && button5.getText().equals(j) && button9.getText().equals(j)) {
				Venceu(j, i);
				return;
			}
			// Cruzada 2
			if (button3.getText().equals(j) && button5.getText().equals(j) && button7.getText().equals(j)) {
				Venceu(j, i);
				return;
			}

			// Empate
			if (!button1.getText().equals("") && !button2.getText().equals("") && !button3.getText().equals("")
					&& !button4.getText().equals("") && !button5.getText().equals("") && !button6.getText().equals("")
					&& !button7.getText().equals("") && !button8.getText().equals("")
					&& !button9.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "A Partida Empatou!!");
				Empates++;
				ZerarJogo();
				return;
			}
		}
	}

	private void Venceu(String jog, int i) {
		SomaVitoria(i);
		JOptionPane.showMessageDialog(null, "O Jogador " + jog + " Venceu a Partida!");
		ZerarJogo();
	}
	/*
	 * FUNÇÃO PARA SOMAR A VITORIA AO JOGADOR EM UM VETOR A FUNÇÃO SEMPRE VAI
	 * RECEBER 1 E 2 COMO NO VETOR COMEÇA EM 0, DIMINUI 1
	 */

	private void SomaVitoria(int jog) {
		Vitorias[jog - 1]++;
		AtualizaVitorias();
	}

	private void AcBt1() {
		if (!button1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, JogadaFeita);
			return;
		}
		button1.setText(getJogador());
		Jogadas();
	}

	private void AcBt2() {
		if (!button2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, JogadaFeita);
			return;
		}
		button2.setText(getJogador());
		Jogadas();
	}

	private void AcBt3() {
		if (!button3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, JogadaFeita);
			return;
		}
		button3.setText(getJogador());
		Jogadas();
	}

	private void AcBt4() {
		if (!button4.getText().equals("")) {
			JOptionPane.showMessageDialog(null, JogadaFeita);
			return;
		}
		button4.setText(getJogador());
		Jogadas();

	}

	private void AcBt5() {
		if (!button5.getText().equals("")) {
			JOptionPane.showMessageDialog(null, JogadaFeita);
			return;
		}
		button5.setText(getJogador());
		Jogadas();

	}

	private void AcBt6() {
		if (!button6.getText().equals("")) {
			JOptionPane.showMessageDialog(null, JogadaFeita);
			return;
		}
		button6.setText(getJogador());
		Jogadas();

	}

	private void AcBt7() {
		if (!button7.getText().equals("")) {
			JOptionPane.showMessageDialog(null, JogadaFeita);
			return;
		}
		button7.setText(getJogador());
		Jogadas();

	}

	private void AcBt8() {
		if (!button8.getText().equals("")) {
			JOptionPane.showMessageDialog(null, JogadaFeita);
			return;
		}
		button8.setText(getJogador());
		Jogadas();

	}

	private void AcBt9() {
		if (!button9.getText().equals("")) {
			JOptionPane.showMessageDialog(null, JogadaFeita);
			return;
		}
		button9.setText(getJogador());
		Jogadas();

	}

	private void ConfigBotoes() {
		button1.setFont(new Font("Impact", Font.PLAIN, 40));
		button1.setBounds(10, 11, 115, 115);
		getContentPane().add(button1);

		button2.setFont(new Font("Impact", Font.PLAIN, 40));
		button2.setBounds(135, 11, 115, 115);
		getContentPane().add(button2);

		button3.setFont(new Font("Impact", Font.PLAIN, 40));
		button3.setBounds(260, 11, 115, 115);
		getContentPane().add(button3);

		button4.setFont(new Font("Impact", Font.PLAIN, 40));
		button4.setBounds(10, 137, 115, 115);
		getContentPane().add(button4);

		button5.setFont(new Font("Impact", Font.PLAIN, 40));
		button5.setBounds(135, 137, 115, 115);
		getContentPane().add(button5);

		button6.setFont(new Font("Impact", Font.PLAIN, 40));
		button6.setBounds(260, 137, 115, 115);
		getContentPane().add(button6);

		button7.setFont(new Font("Impact", Font.PLAIN, 40));
		button7.setBounds(10, 263, 115, 115);
		getContentPane().add(button7);

		button8.setFont(new Font("Impact", Font.PLAIN, 40));
		button8.setBounds(135, 263, 115, 115);
		getContentPane().add(button8);

		button9.setFont(new Font("Impact", Font.PLAIN, 40));
		button9.setBounds(260, 263, 115, 115);
		getContentPane().add(button9);

		lblInformaes.setFont(new Font("Microsoft Tai Le", Font.BOLD, 17));
		lblInformaes.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformaes.setBounds(385, 11, 249, 28);
		getContentPane().add(lblInformaes);

		btnNovoJogo.setBounds(400, 263, 219, 51);
		getContentPane().add(btnNovoJogo);

		btnSairDoJogo.setBounds(400, 327, 219, 51);
		getContentPane().add(btnSairDoJogo);

		btnSobreJogo.setBounds(400, 199, 219, 51);
		getContentPane().add(btnSobreJogo);

		separator.setBounds(400, 37, 219, 2);
		getContentPane().add(separator);

		lblJogadorX.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblJogadorX.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogadorX.setBounds(400, 43, 219, 14);
		getContentPane().add(lblJogadorX);

		lblVitoriasX.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		lblVitoriasX.setHorizontalAlignment(SwingConstants.CENTER);
		lblVitoriasX.setBounds(400, 60, 219, 14);
		getContentPane().add(lblVitoriasX);

		separator_1.setBounds(400, 85, 219, 2);
		getContentPane().add(separator_1);

		lblJogadorO.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogadorO.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblJogadorO.setBounds(400, 98, 219, 14);
		getContentPane().add(lblJogadorO);

		lblVitoriasO.setHorizontalAlignment(SwingConstants.CENTER);
		lblVitoriasO.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		lblVitoriasO.setBounds(400, 115, 219, 14);
		getContentPane().add(lblVitoriasO);

		separator_2.setBounds(400, 144, 219, 2);
		getContentPane().add(separator_2);

		lblEmpates.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpates.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblEmpates.setBounds(400, 159, 219, 14);
		getContentPane().add(lblEmpates);
	}

	private void AcoesBotao() {
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcBt1();
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcBt2();
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcBt3();
			}
		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcBt4();
			}
		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcBt5();
			}
		});
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcBt6();
			}
		});
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcBt7();
			}
		});
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcBt8();
			}
		});
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcBt9();
			}
		});
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZerarJogo();
			}
		});
		btnSairDoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSobreJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Desenvolvedor do Jogo: Eduardo Altemar Assunção\n\n"
								+ "Este Jogo foi desenvolvido com objetivo acadêmico\n"
								+ "para o curso de Engenharia de Software\n\n" + "Faculdade Assis Gurgacz\n"
								+ "23 de Março de 2020");
			}
		});
	}
	private void AtualizaVitorias() {
		lblVitoriasX.setText("Vitórias: " + Vitorias[0]);
		lblVitoriasO.setText("Vitórias: " + Vitorias[1]);
		lblEmpates.setText("Empates: " + Empates);
	}
	private void ZerarJogo() {
		button1.setText("");
		button2.setText("");
		button3.setText("");
		button4.setText("");
		button5.setText("");
		button6.setText("");
		button7.setText("");
		button8.setText("");
		button9.setText("");
		Jogador = 0;
	}
}