package fr.insalyon.teamparrot.testjavafx.controller;

interface Command {
    void execute();
    void rollback();
}
