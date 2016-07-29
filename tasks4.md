# Tasks
# Total estimate:193m real:177m
--------------------------------------------------------------------------------------------------0m
[*] products                                                                                   

1. return_201_when_POST_products_with_parameters(create product)            15m    

2. return_400_when_POST_fails(name,description,price are empty)             18m    

3. [Database test] find_product_by_productid                                28m    

4. return_product_when_GET_product_by_productid                             32m    

5. return_404_when_GET_product_by_productid_fails(productid not found)      35m    

6. [Database Test] find_all_products                                        45m     

7. return_products_when_GET_products                                        55m     

--------------------------------------------------------------------------------------------------45m
[*] users                                                                                              

1. return_201_when_POST_users_with_parameters(create user)                  70m    

2. return_400_when_POST_fails(name is empty)                                73m     

3. [Database Test] find_user_by_userid                                      83m     

4. return_user_when_GET_user_by_userid                                      88m     

5. return_404_when_GET_user_by_id_fails(userid not found)                   91m     

--------------------------------------------------------------------------------------------------76m
[*] orders                                                                               

1. return_201_when_POST_orders_with_parameters(create orders)              111m    

2. return_400_when_POST_fails(name,address,phone are empty)                114m    

3. [Database test] find_order_by_orderid                                   129m    

4. return_order_when_GET_order_by_orderid                                  134m    

5. return_404_when_GET_order_fails(not found orderid by userid)            137m    

6. [Database Test] find_all_orders                                         152m     

7. return_orders_when_GET_orders                                           157m     

--------------------------------------------------------------------------------------------------144m
[*] payments                                                                             

1. return_201_when_POST_payment_with_patameters(create payment)            172m    

2. return_400_when_POST_fails(amount and pay_type are empty)               175m    

4. [Database Test] find_payment_by_orderid                                 185m    

5. return_payment_when_GET_payment_by_orderid                              190m    

6. return_404_when_GET_payment_fails(not found payment by orderid)         193m    

--------------------------------------------------------------------------------------------------177m





# Database
--------------------------------------------------------------------------------------------------
1.Products
    id
    name
    description
    price
--------------------------------------------------------------------------------------------------
2.users
    id
    name
--------------------------------------------------------------------------------------------------
3.orders
    id
    name
    address
    phone
    time
    userid
--------------------------------------------------------------------------------------------------
4.orderitems
    orderid
    productid
    quantity
    amount
--------------------------------------------------------------------------------------------------
5.payments
    orderid
    paytype
    paytime
    amount
--------------------------------------------------------------------------------------------------








