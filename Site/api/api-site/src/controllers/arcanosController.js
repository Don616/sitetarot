var arcanoModel = require("../models/arcanoModel");


function salvar(req, res) {
    var user = req.body.userServer;
    var sorteada = req.body.sorteadaServer;


    if (user == undefined) {
        res.status(400).send("Seu user está undefined!");
    } else if (sorteada == undefined) {
        res.status(400).send("Sua carta está undefined!");
    } 
        
        arcanoModel.salvar(user, sorteada)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
    function obterTotalCartas(req, res) {

        var user = req.params.user;
    
        arcanoModel.obterTotalCartas(user).then(function (resultado) {
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
    function pegarCartaQueMaisSaiu(req, res) {

        var user = req.params.user;
    
        arcanoModel.pegarCartaQueMaisSaiu(user).then(function (resultado) {
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
    function obterKeywords(req, res) {

        var carta = req.params.carta;
    
        arcanoModel.obterKeywords(carta).then(function (resultado) {
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
    function obterNaipe(req, res) {

        var user = req.params.user;
    
        arcanoModel.obterNaipe(user).then(function (resultado) {
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
    pegarCartaQueMaisSaiu,
    salvar,
    obterTotalCartas,
    obterKeywords,
    obterNaipe

}