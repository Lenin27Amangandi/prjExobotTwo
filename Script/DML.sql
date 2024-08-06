-- database: ../database/ExaBot2k24.sqlite
/*
CopyRight
autor: Lenin Amangandi
fecha: 2024-07-21
Description: insertar datos iniciales
*/


INSERT INTO CatalogoTipo
    (Nombre,Descripcion) VALUES
    ("TipoPersona"      ,"Tipos soldados,Mecanicos ... etc")                    --IdCatalogoTipo1
    ,("Sexo"            ,"Masculino,Femenino ... etc")                          --IdCatalogoTipo2
    ,("EstadoCivil"     ,"Soltero,Divorciado,Viudo ... etc")                    --IdCatalogoTipo3
    ,("Raza"            ,"Blanco,Mestizo,Indigena,Afroecuatoriano ... etc");    --IdCatalogoTipo4


INSERT INTO Catalogo
(IdCatalogoTipo,Nombre      ,Descripcion) VALUES
--Insertamos todo lo que debe ir con el ejercito
(   1          ,"Soldado"           ,"Tipos personaje del ejercito")    --IdCatalogo=1
,(   1          ,"Mecanico"         ,"Tipos personaje del ejercito")    --IdCatalogo=2
,(   1          ,"ExpertoIngles"    ,"Tipos personaje del ejercito")    --IdCatalogo=3
,(   1          ,"ExpertoEspañol"   ,"Tipos personaje del ejercito")    --IdCatalogo=4
--Insertamos todo lo que debe ir con sexo
,(   2          ,"Masculino"        ,"Tipos de sexo")   --IdCatalogo=5
,(   2          ,"Femenino"         ,"Tipos de sexo")   --IdCatalogo=6
,(   2          ,"Hermafrodita"     ,"Tipos de sexo")   --IdCatalogo=7
,(   2          ,"Asexual"          ,"Tipos de sexo")   --IdCatalogo=8
--Insertamos todo lo que debe ir con el estado civil
,(   3          ,"Soltero"          ,"Tipos de estado civil")   --dCatalogo=9
,(   3          ,"Casado"           ,"Tipos de estado civil")   --dCatalogo=10
,(   3          ,"Divorciado"       ,"Tipos de estado civil")   --dCatalogo=11
,(   3          ,"Viudo"            ,"Tipos de estado civil")   --IdCatalogo=12
--Insertamos todo lo que debe ir con la etnia
,(   4          ,"Aforecuatoriano"  ,"Tipos de raza")  --IdCatalogo=13
,(   4          ,"Blanco"           ,"Tipos de raza")   --IdCatalogo=14
,(   4          ,"Mestizo"          ,"Tipos de raza")   --IdCatalogo=15
,(   4          ,"Indigena"         ,"Tipos de raza");   --IdCatalogo=16

INSERT INTO IABot 
(Nombre ,   Observacion) VALUES
("IA-Ruso" , "Inteligencia Artifical");

INSERT INTO ExaBot
 (IdIABot,Nombre,Serie) VALUES
 (1,"exabot1","Serie1")
,(1,"exabot2","Serie2");

INSERT INTO Persona
 (IdCatalogoTipoPersona  ,IdCatalogoSexo ,IdCatalogoEstadoCivil  , Cedula        , Nombre     , Apellido) VALUES
 (1                      ,      5        ,          9            , "1753193828" ,"Lenin"      , "Amangandi")
,(2                      ,      5        ,         10            , "1753193827" ,"Levy"       ,"Ackerman")
,(3                      ,      5        ,         11            , "1753193826" ,"Eren"       ,"Jeager")
,(4                      ,      5        ,         12            , "1753193825" ,"Lawliet"    ,"Yagami")
,(1                      ,      6        ,          9            , "1753193824" ,"Alice"      ,"Schuberg")
,(2                      ,      6        ,         10            , "1753193823" ,"Historia"   ,"Reiss")
,(3                      ,      6        ,         11            , "1753193822" ,"Touka"      ,"Kirishima")
,(4                      ,      6        ,         12            , "1753193821" ,"Xenovia"    ,"Quarta");

SELECT IdCatalogo 
                ,IdCatalogoTipo  
                ,Nombre          
                ,Descripcion     
                ,Estado          
                ,FechaCrea       
                ,FechaModifica   
                From Catalogo    
                WHERE Estado='A' 
                AND   IdCatalogoTipo = 1;

SELECT IdCatalogo
                ,IdCatalogoTipo 
                ,Nombre         
                ,Descripcion    
                ,Estado         
                ,FechaCrea      
                ,FechaModifica  
                From Catalogo   
                WHERE Estado='A'
                AND   IdCatalogoTipo=2;

    SELECT COUNT(*) TotalReg
    FROM Catalogo
    WHERE Estado='A' AND IdCatalogoTipo=2;

SELECT IdCatalogo 
                ,IdCatalogoTipo  
                ,Nombre          
                ,Descripcion     
                ,Estado          
                ,FechaCrea       
                ,FechaModifica   
                From Catalogo    
                WHERE Estado='A' 
                AND   IdCatalogoTipo = 3;
