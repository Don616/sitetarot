
graficoPizza()

function graficoPizza(){// Cria o gráfico de pizza

  
const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ['Paus', 'Copas', 'Espadas', 'Moedas', 'Espírito'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2],
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