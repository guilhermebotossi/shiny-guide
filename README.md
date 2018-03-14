#To run Application
 ./gradlew bootRun

#Access the Controllers through swagger
http://localhost:8080/swagger-ui.html

#Endpoints :

Mapped "{[/cart/viewCart],methods=[GET]}" 
Mapped "{[/cart/addItem],methods=[POST]}" 
Mapped "{[/cart/updateItem],methods=[PUT]}" 
Mapped "{[/cart/removeItem],methods=[DELETE]}" 
Mapped "{[/product/list/{id}],methods=[GET]}" 
Mapped "{[/product/edit],methods=[POST]}" 
Mapped "{[/product/delete/{id}],methods=[DELETE]}"
Mapped "{[/product/add],methods=[PUT]}" 
Mapped "{[/product/list],methods=[GET]}"

#Produtos Inicialmente disponiveis 
    [
        {
            id: 1,
            name: "Televisão",
            value: 1500.5
        },
        {
            id: 3,
            name: "Geladeira",
            value: 6000.25
        },
        {
            id: 2,
            name: "Celular",
            value: 3595.5
        },
        {
            id: 4,
            name: "Notebook",
            value: 2650.5
        },
        {
            id: 5,
            name: "Mesa",
            value: 500
        }
    ]