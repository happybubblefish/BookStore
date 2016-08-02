

$(document).ready(function () {
    $('#btnGetWeather').click(function () {
        var resultElement = $('#resultWeatherDiv');
        resultElement.html('');
        var requestData = $('#txtCity').val() + ',' + $('#txtCountry').val();
        var cityName = $('#txtCity').val()

        $.ajax({
            url: 'http://api.openweathermap.org/data/2.5/weather?q=' + cityName + '&mode=html' + '&appid=8b3883f76906170c401827df71d45069 ',
           
            type: 'get',
            //data: { q: requestData }, 
            dataType: 'html',
            success: function (response) {
                $('#resultWeatherDiv').replaceWith($('#resultWeatherDiv').html(response));
            },
            error: function (err) {
                resultElement.html(err);
            }
        });
    });
    $.get("http://ipinfo.io", function (response) {
        $("#ip").html("IP: " + response.ip);
        $("#address").html("Location: " + response.city + ", " + response.region);
        var splitR = response.loc.split(",");
        $("#lat").html("LAT: " + splitR[0]);
        $("#lon").html("LON: " + splitR[1]);
        $("#details").html(JSON.stringify(response, null, 4));
        $.ajax({
            url: 'http://api.openweathermap.org/data/2.5/weather?lat=' + splitR[0] + '&lon=' + splitR[1] + '&mode=html' + '&appid=8b3883f76906170c401827df71d45069',
            type: 'get',
            dataType: 'html',
            success: function (innerResponse) {
                $('#resultWeatherDiv').replaceWith($('#resultWeatherDiv').html(innerResponse));
            }
        });

    }, "jsonp");
});

