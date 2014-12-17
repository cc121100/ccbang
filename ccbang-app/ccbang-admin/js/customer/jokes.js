var jokeEditor;

jokeEditor = new $.fn.dataTable.Editor( {
	ajax: {
            create: {
                type: 'PUT',
                url:  'http://localhost:8888/ccserver/joke',
                // data:function(joke){
                // 	joke.content = $("#DTE_Field_joke.content").val();
                // 	joke.time = $("#DTE_Field_joke.time").val();
                // 	return joke;
                // }
                // data:{
                // 	"joke.content":"$('#DTE_Field_joke.content').val()"
                // 	// "joke.time":'$("#DTE_Field_joke.time").val()'
                // }
				// data:{
    //             	"joke.content":$("#DTE_Field_joke.content").val(),
    //             	"joke.time":$("#DTE_Field_joke.time").val()
    //             }                
            },
            edit: {
                type: 'POST',
                url:  'http://localhost:8888/ccserver/joke'
            },
            remove: {
                type: 'DELETE',
                url:  'http://localhost:8888/ccserver/joke'
            }
        },
	table: "#jokeTbl",
	fields: [
	        	{
	                label: "Content:",
	                name: "joke.content"
	            }, {
	                label: "Time:",
	                name: "joke.time"
	                
	            }
			]
} );

$('#jokeTbl').DataTable( {
	dom: "Tfrtip",
    processing: true,
    serverSide: true,
    ajax: "http://localhost:8888/ccserver/jokes",
    columns: [
        
        { data: "id" },
        { data: "content" },
        { data: "time" },
    ],

    tableTools: {
        sRowSelect: "os",
        aButtons: [
            { sExtends: "editor_create", editor: jokeEditor },
            { sExtends: "editor_edit",   editor: jokeEditor },
            { sExtends: "editor_remove", editor: jokeEditor }
        ]
    }
} );
