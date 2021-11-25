

var naipe1 = localStorage.getItem('naipe1');
var naipe2 = localStorage.getItem('naipe2');
var naipe3 = localStorage.getItem('naipe3');
var naipe4 = localStorage.getItem('naipe4');
var naipe5 = localStorage.getItem('naipe5');

graficoPizza()

function graficoPizza(){// Cria o gráfico de pizza

  
const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ['Paus', 'Copas', 'Espadas', 'Moedas', 'Espírito'],
        datasets: [{
            label: '# of Votes',
            data: [naipe2, naipe3, naipe4, naipe5, naipe1],
            backgroundColor: [
                'red',
                'aqua',
                'gold',
                'green',
                'purple'
                
            ],
            borderColor: [
                'red',
                'aqua',
                'gold',
                'green',
                'purple'
                
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

}