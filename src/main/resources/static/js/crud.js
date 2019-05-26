		function listarTodo(){
			var url="http://localhost:8080/api/list";
			
			$('table tr:not(:first-child)').remove();
			
			$.getJSON(url, function(result){
      			$.each(result, function(i, field){
		   			$("table").append("<tr><td>"+field.id+"</td><td>"+field.ruta+"</td></tr>");
    			});
		    });	
		}

		$("#listar").click(function(){
			listarTodo();	
		});
		
		$("#listarid").click(function(){
			var idPhoto=$("#photoid").val();
			var url="http://localhost:8080/api/getPhoto?id="+idPhoto;
			
			$('table tr:not(:first-child)').remove();
			
			$.getJSON(url, function(result){
				console.log(result);
	   			$("table").append("<tr id='fila'><td>"+result.id+"</td><td>"+result.ruta+"</td></tr>");
		    });
		});
		
		$("#insertar").click(function(){
			var url="http://localhost:8080/api/save";
			var ruta=$("#photoruta").val();
			var datos={"ruta": ruta};
			$.ajax({
				method: "POST",
				url: url,
				dataType: "json",
				data: datos,
				success: function(data){
					alert("Se ha insertado correctamente!");
					listarTodo();
				},
				error: function(data){
					alert("Error!");
				}
			});
		});
		
		$("#update").click(function(){
			var url="http://localhost:8080/api/update";
			var idPhoto=$("#photoid").val();
			var routePhoto=$("#photoruta").val();
			var datos={"id": idPhoto, "ruta": routePhoto};
			$.ajax({
				method: "POST",
				url: url,
				dataType: "json",
				data: datos,
				success: function(data){
					alert("Se ha modificado correctamente!");
					listarTodo();
				},
				error: function(data){
					alert("Error!");
				}
			});
		});
		
		$("#delid").click(function(){
			var idDelete=$("#photoid").val();
			var url="http://localhost:8080/api/deletePhoto?id="+idDelete;

			$.ajax({
				method: "GET",
				url: url,
				success: function(data){
					alert("Se ha eliminado correctamente!");
					listarTodo();
				},
				error: function(data){
					alert("Error!");
				}
			});
		});
		
		$("#deleteAll").click(function(){
			var url="http://localhost:8080/api/deleteAllPhotos";
			
			$('table tr:not(:first-child)').remove();
			
			$.ajax({
				method: "GET",
				url: url,
				success: function(data){
					alert("Se han eliminado todos los datos!");
					listarTodo();
				},
				error: function(data){
					alert("Error!");
				}
			});
		});