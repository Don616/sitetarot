var arcanoModel = require("../models/arcanoModel");

function pegarCartaQueMaisSaiu(req, res) {

    var ID_USER = req.params.ID_USER;

    console.log(`Recuperando medidas em tempo real`);

    arcanoModel.pegarCartaQueMaisSaiu(ID_USER).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

module.exports = {
    pegarCartaQueMaisSaiu

}