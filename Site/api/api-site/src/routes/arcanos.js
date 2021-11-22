var express = require("express");
var router = express.Router();

var arcanosController = require("../controllers/arcanosController");

router.get("/dados/:ID_USER", function (req, res) {
    arcanosController.pegarCartaQueMaisSaiu(req, res);
});



module.exports = router;