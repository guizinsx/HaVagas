# HaVagas

App Android com um formulário de cadastro de candidatos a vagas de emprego, feito em **Kotlin**.

> Projeto desenvolvido na faculdade, na disciplina de Programação para Dispositivos Móveis (PDM), em 2024.

## Funcionalidades

- Formulário com nome, e-mail, telefone (comercial ou residencial), celular opcional, sexo, data de nascimento, formação e vagas de interesse
- Opção de receber atualizações por e-mail
- Campos que mudam conforme a formação escolhida:
  - **Fundamental ou Médio:** ano de formatura
  - **Graduação ou Especialização:** ano de conclusão e instituição
  - **Mestrado ou Doutorado:** ano de conclusão, instituição, título da monografia e orientador
- Campo de celular que só aparece quando a opção é marcada
- Botão **Salvar**, que mostra um resumo do cadastro, e botão **Limpar**, que zera o formulário

## Tecnologias

- Kotlin
- Android SDK (mínimo API 24, alvo API 34)
- View Binding
- Componentes de formulário do Android: Spinner, CheckBox, RadioButton e EditText

## Como rodar

1. Clone o repositório e abra no Android Studio.
2. Rode o app num emulador ou celular com Android 7.0 ou superior.
