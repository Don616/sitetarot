var database = require("../database/config");

function pegarCartaQueMaisSaiu(ID_USER) {
    instrucaoSql = `SELECT FK_ARCANOS FROM DADOS 
    WHERE FK_USUARIO = ${ID_USER} 
    GROUP BY FK_ARCANOS 
    ORDER BY COUNT(FK_ARCANOS) 
    DESC LIMIT 1;`;

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

module.exports = {
    pegarCartaQueMaisSaiu
}