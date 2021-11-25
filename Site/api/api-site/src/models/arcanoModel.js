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
    instrucaoSql = `SELECT (SELECT FK_ARCANOS FROM DADOS WHERE FK_USUARIO = ${user} GROUP BY FK_ARCANOS ORDER BY COUNT(FK_ARCANOS) DESC LIMIT 1;) AS 'maiorcarta';`;
    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

module.exports = {
    pegarCartaQueMaisSaiu,
    salvar,
    obterTotalCartas,
}