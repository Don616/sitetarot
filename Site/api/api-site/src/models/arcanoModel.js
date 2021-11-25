var database = require("../database/config");

function salvar(user, sorteada) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", user, sorteada);
    var instrucao = `INSERT INTO DADOS (FK_USUARIO,FK_ARCANOS) VALUES (${user},${sorteada})`;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}
function obterTotalCartas(user) {
    instrucaoSql = `SELECT (SELECT COUNT(FK_ARCANOS) AS QT FROM DADOS WHERE FK_USUARIO = ${user}) AS 'quantidade';`;
    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}
function pegarCartaQueMaisSaiu(user) {
    instrucaoSql = `SELECT FK_ARCANOS FROM DADOS WHERE FK_USUARIO = ${user} GROUP BY FK_ARCANOS ORDER BY COUNT(FK_ARCANOS) DESC LIMIT 1;`;
    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    console.log('Pegar carta chegou na Model')
    return database.executar(instrucaoSql);
}
function obterKeywords(carta) {
    instrucaoSql = `SELECT KEY1,KEY2,KEY3 FROM KEYWORDS WHERE FK_ARCANOS = ${carta};`;
    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    console.log('Obter Keyword chegou na Model')
    return database.executar(instrucaoSql);
}
function obterNaipe(user) {
    instrucaoSql = `SELECT ARCANOS.NAIPE_ARCANO FROM DADOS JOIN ARCANOS ON NUMERO_ARCANO = FK_ARCANOS JOIN USUARIO ON ID_USUARIO = FK_USUARIO WHERE FK_USUARIO = ${user};`;
    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    console.log('Obeter Naipe chegou na Model')
    return database.executar(instrucaoSql);
}

module.exports = {
    pegarCartaQueMaisSaiu,
    salvar,
    obterTotalCartas,
    obterKeywords,
    obterNaipe
}