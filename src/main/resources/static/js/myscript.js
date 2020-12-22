var tablePerson = {
	create: function(){
		$.ajax({
		url : '/person/get-all',
		method : 'get',
		contentType : 'application/json',
		success : function(res, status, xhr) {
			data = "";
			$.each(res, function(index, value) {
				data += "<tr>";
				data += "<td>" + value.id + "</td>";
				data += "<td>" + value.firstName + "</td>";
				data += "<td>" + value.lastName + "</td>";
				data += "<td>" + value.nik + "</td>";
				data += "<td>" + value.kodePerson + "</td>";				
				data += "<tr>";
			});
			$('#body-person').append(data);
			console.log(res)
		},
		error : function(e) {
			alert(e);
			console.log(e);
		}	
		});
	},
	
	getPerson: function(){
		$.ajax({
            url: '/person/get-all',
            type: 'get',
            contentType: 'application/json',
            success: function(res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    $('#table-person').DataTable({
                        data: res,
                        columns: [{
                            title: "id",
                            data: "id"
                        }, {
                            title: "First Name",
                            data: "firstName"
                        }, {
                            title: "Last Name",
                            data: "lastName"
                        }, {
                            title: "NIK",
                            data: "nik"
                        }, {
                            title: "Kode Person",
                            data: "kodePerson"
                        }, {
                            title: "Action",
                            data: null,
                            render: function(data, type, row) {
                                console.log(data)
                                return "<button class='btn btn-warning' onclick=formPerson.setEditData('" + data.id + "')>Edit</button>" + " " + 
                                		"<button class='btn btn-danger' onclick=formPerson.delete('" + data.id + "')>Delete</button>"
                            }
                        }]
                    });

                } else {}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}
}


var formPerson = {
	save: function(){
		var person = {}
		person["firstName"] = $('#firstName').val();
		person["lastName"] = $('#lastName').val();
		person["nik"] = $('#nik').val();
		person["kodePerson"] = $('#kodePerson').val();
		
		$.ajax({
			method:'post',
			url:'/person/post-person-status',
			contentType:'application/json',
			data: JSON.stringify(person),
			success: function(res) {
				console.log(res)
			}
		})		
	},
	
	setEditData: function(id) {
		$.ajax({
			method:'get',
			url:'/person/by-id/' + id,
			contentType: 'application/json',
			type: 'json',
			success: function(res) {
				console.log(res)
				$('#id').val(res.id)
				$('#firstName').val(res.firstName)
				$('#lastName').val(res.lastName)
				$('#nik').val(res.nik)
				$('#kodePerson').val(res.kodePerson)
				
				$('#btn-save').off('click').on('click', function() {
					formPerson.update(res.id);
					tablePerson.getPerson;
						$('#btn-save').off('click').on('click', function() {
							formPerson.save();
						})
				})
			}
		})
	},
	
	update: function(id) {
		var person = {}
		person["id"] = $('#id').val();
		person["firstName"] = $('#firstName').val();
		person["lastName"] = $('#lastName').val();
		person["nik"] = $('#nik').val();
		person["kodePerson"] = $('#kodePerson').val();
		
		$.ajax({
			method:'put',
			url:'/person/update-person/' + id,
			contentType:'application/json',
			data: JSON.stringify(person),
			success: function(res) {
				console.log(res)
			}
		})			
	},
	
	delete: function(id) {
		$.ajax({
			method: 'delete',
			url: '/person/delete/' + id,
			success: function(res) {
				alert('Deleted!');
				location.reload();
			}
		})
	}
}