-- database: ../database/ExaBot2k24.sqlite
/*
CopyRight
autor: Lenin Amangandi
fecha: 2024-07-21
*/

DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS IABot;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS PersonaTipo;

CREATE TABLE IABot (
    IdIABot         INTEGER PRIMARY KEY autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Observacion    TEXT
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) 
);
CREATE TABLE ExaBot (
    IdExaBot       INTEGER PRIMARY KEY autoincrement
    ,IdIABot        INTEGER NOT NULL
    ,Nombre         TEXT NOT NULL
    ,Serie          TEXT NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) 
    ,CONSTRAINT     fk_IABot FOREIGN KEY (IdIABot) REFERENCES  IABot(IdIABot)
);

CREATE TABLE PersonaTipo (
    IdPersonaTipo  INTEGER PRIMARY KEY autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) --current_timestamp
);
CREATE TABLE Persona (
    IdPersona      INTEGER PRIMARY KEY autoincrement
    ,IdPersonaTipo  INTEGER NOT NULL REFERENCES PersonaTipo(IdPersonaTipo)
    ,Cedula         TEXT NOT NULL UNIQUE
    ,Nombre         TEXT NOT NULL
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) 
);