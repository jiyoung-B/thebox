// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ["범죄도시3", "트랜스포머: 비스트의 서막", "포켓 몬스터 DP: 아르세우스 초극의 시공으로", "가디언즈 오브 갤럭시: Volume 3", "인어공주", "기타"],
    datasets: [{
      data: [70.8, 16.6, 3.5, 2.4, 1.6, 5.1],
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', 'grey', 'lightsalmon', 'mediumpurple'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf', 'black', 'indianred', 'mediumslateblue'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});
