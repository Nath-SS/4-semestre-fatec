package com.example.atividadepratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculadora extends AppCompatActivity {

    EditText edtCalculo;

    Button btnSoma, btnSubtracao, btnMultiplicacao, btnDivisao,
            btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis,
            btnSete, btnOito, btnNove, btnZero, btnCalcular, btnVoltar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        edtCalculo = findViewById(R.id.edtCalculo);
        btnSoma = findViewById(R.id.btnSoma);
        btnSubtracao = findViewById(R.id.btnSubtracao);
        btnMultiplicacao = findViewById(R.id.btnMultiplicacao);
        btnDivisao = findViewById(R.id.btnDivisao);
        btnUm = findViewById(R.id.btnUm);
        btnDois = findViewById(R.id.btnDois);
        btnTres = findViewById(R.id.btnTres);
        btnQuatro = findViewById(R.id.btnQuatro);
        btnCinco = findViewById(R.id.btnCinco);
        btnSeis = findViewById(R.id.btnSeis);
        btnSete = findViewById(R.id.btnSete);
        btnOito = findViewById(R.id.btnOito);
        btnNove = findViewById(R.id.btnVoltar3);
        btnZero = findViewById(R.id.btnZero);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnVoltar2 = findViewById(R.id.btnVoltar2);

        btnVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void Soma(View view) {
        String textoAtual = edtCalculo.getText().toString();
        textoAtual = textoAtual + "+";
        edtCalculo.setText(textoAtual);
    }

    public void Subtracao(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "-";
        edtCalculo.setText(textoAtual);
    }

    public void Divisao(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "/";
        edtCalculo.setText(textoAtual);
    }

    public void Multiplicacao(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "x";
        edtCalculo.setText(textoAtual);
    }

    public void Zero(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "0";
        edtCalculo.setText(textoAtual);
    }

    public void Um(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "1";
        edtCalculo.setText(textoAtual);
    }

    public void Dois(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "2";
        edtCalculo.setText(textoAtual);
    }

    public void Tres(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "3";
        edtCalculo.setText(textoAtual);
    }

    public void Quatro(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "4";
        edtCalculo.setText(textoAtual);
    }

    public void Cinco(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "5";
        edtCalculo.setText(textoAtual);
    }

    public void Seis(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "6";
        edtCalculo.setText(textoAtual);
    }

    public void Sete(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "7";
        edtCalculo.setText(textoAtual);
    }

    public void Oito(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "8";
        edtCalculo.setText(textoAtual);
    }

    public void Nove(View view){
        String textoAtual = edtCalculo.getText().toString();
        textoAtual += "9";
        edtCalculo.setText(textoAtual);
    }

    // Método para avaliar a expressão matemática usando o interpretador de expressões
    private double eval(final String expressao) {
        return new Object() {
            int pos = -1, ch;

            void proximoChar() {
                ch = (++pos < expressao.length()) ? expressao.charAt(pos) : -1;
            }

            boolean whitespace() {
                while (Character.isWhitespace(ch)) proximoChar();
                return false;
            }

            double parse() {
                proximoChar();
                double x = parseExpression();
                if (pos < expressao.length()) throw new RuntimeException("Caractere inesperado: " + (char) ch);
                return x;
            }

            // Sintaxe:
            // expression ::= term | expression `+` term | expression `-` term
            // term ::= factor | term `x` factor | term `/` factor
            // factor ::= `+` factor | `-` factor | `(` expression `)`
            //        | numero | func (expression)
            // func ::= `sqrt` | `sin` | `cos` | `tan` | `abs` | `ln` | `log`
            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (whitespace()) continue;
                    if (ch == '+') { // adição
                        proximoChar();
                        x += parseTerm();
                    } else if (ch == '-') { // subtração
                        proximoChar();
                        x -= parseTerm();
                    } else {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (whitespace()) continue;
                    if (ch == 'x') { // multiplicação
                        proximoChar();
                        x *= parseFactor();
                    } else if (ch == '/') { // divisão
                        proximoChar();
                        double divisor = parseFactor();
                        if (divisor == 0) throw new ArithmeticException("Divisão por zero");
                        x /= divisor;
                    } else {
                        return x;
                    }
                }
            }

            double parseFactor() {
                if (whitespace()) return parseFactor();
                if (ch == '+' || ch == '-') { // tratamento de sinal
                    boolean negativo = ch == '-';
                    proximoChar();
                    double x = parseFactor();
                    return negativo ? -x : x;
                }
                if (ch == '(') { // parênteses
                    proximoChar();
                    double x = parseExpression();
                    if (ch != ')') throw new RuntimeException("Parênteses não fechados");
                    proximoChar();
                    return x;
                }
                double numero = 0;
                // dígitos do número
                while (Character.isDigit(ch)) {
                    numero = numero * 10 + ch - '0';
                    proximoChar();
                }
                return numero;
            }
        }.parse();
    }
    public void Calcular(View view) {
        String expressao = edtCalculo.getText().toString();
        double resultado = 0;

        try {
            // Avaliar a expressão matemática
            resultado = eval(expressao);
            // Exibir o resultado no EditText
            edtCalculo.setText(String.valueOf(resultado));
        } catch (Exception e) {
            // Se ocorrer um erro ao avaliar a expressão, exibir uma mensagem de erro
            edtCalculo.setText("Erro");
        }
    }


}