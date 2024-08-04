-- database: ../database/ExaBot2k24.sqlite
/*
CopyRight
autor: Lenin Amangandi
fecha: 2024-07-21
*/

DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS CatalogoTipo;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS IABot;

CREATE TABLE CatalogoTipo (
    IdCatalogoTipo         INTEGER PRIMARY KEY autoincrement
    ,Nombre                VARCHAR(50) NOT NULL UNIQUE
    ,Descripcion           VARCHAR(50)

    ,Estado                VARCHAR(1) DEFAULT('A')
    ,FechaCrea             DATETIME DEFAULT (datetime('now', 'localtime')) 
    ,FechaModifica         DATETIME 
);

CREATE TABLE Catalogo (
    IdCatalogo             INTEGER PRIMARY KEY autoincrement
    ,IdCatalogoTipo        INTEGER NOT NULL REFERENCES CatalogoTipo(IdCatalogoTipo)
    ,Nombre                VARCHAR(50) NOT NULL UNIQUE
    ,Descripcion           VARCHAR(50)

    ,Estado                VARCHAR(1) DEFAULT('A')
    ,FechaCrea             DATETIME DEFAULT (datetime('now', 'localtime')) 
    ,FechaModifica         DATETIME
);

CREATE TABLE IABot (
    IdIABot                 INTEGER PRIMARY KEY autoincrement
    ,Nombre                 VARCHAR(50) NOT NULL UNIQUE
    ,Observacion            TEXT

    ,FechaCrea              DATETIME DEFAULT (datetime('now', 'localtime'))
    ,FechaModifica          DATETIME 
);
CREATE TABLE ExaBot (
    IdExaBot                INTEGER PRIMARY KEY autoincrement
    ,IdIABot                INTEGER NOT NULL
    ,Nombre                 VARCHAR(50) NOT NULL
    ,Serie                  VARCHAR(50) NOT NULL

    ,Estado                 VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea              DATETIME DEFAULT (datetime('now', 'localtime')) 
    ,CONSTRAINT             fk_IABot FOREIGN KEY (IdIABot) REFERENCES  IABot(IdIABot)
);

-- CREATE TABLE PersonaTipo (
--     IdPersonaTipo   INTEGER PRIMARY KEY autoincrement
--     ,Descripcion    TEXT NOT NULL UNIQUE
--     ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
--     ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) --current_timestamp
-- );

CREATE TABLE Persona (
    IdPersona                   INTEGER PRIMARY KEY autoincrement
    ,IdCatalogoTipoPersona      INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    ,IdCatalogoSexo             INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    ,IdCatalogoEstadoCivil      INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    ,Cedula                     VARCHAR(10) NOT NULL UNIQUE
    ,Nombre                     VARCHAR(50) NOT NULL
    ,Apellido                   VARCHAR(50) NOT NULL

    ,Estado                     VARCHAR(1) DEFAULT('A')
    ,FechaCrea                  DATETIME DEFAULT (datetime('now', 'localtime'))
    ,FechaModifica              DATETIME
);
