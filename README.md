# To run Application
 ./gradlew bootRun

# Access the Controllers through swagger
http://localhost:8080/swagger-ui.html

# Endpoints :

Mapped "{[/cart/viewCart],methods=[GET]}" <br>
Mapped "{[/cart/addItem],methods=[POST]}" <br>
Mapped "{[/cart/updateItem],methods=[PUT]}" <br>
Mapped "{[/cart/removeItem],methods=[DELETE]}" <br>
Mapped "{[/product/list/{id}],methods=[GET]}" <br>
Mapped "{[/product/edit],methods=[POST]}" <br>
Mapped "{[/product/delete/{id}],methods=[DELETE]}"<br>
Mapped "{[/product/add],methods=[PUT]}" <br>
Mapped "{[/product/list],methods=[GET]}"<br>

# Produtos Inicialmente disponiveis 
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
