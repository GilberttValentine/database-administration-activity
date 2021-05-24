/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import main.model.entities.Client;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class ClientController {

    private final Client client = new Client();

    public void createClient(Client client) {
        try {
            if (this.client.existByDocument(client.getDocument())) {
                throw new Error("Ya existe un cliente con ese documento");
            }
            this.client.save(client);
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editClient(String document, Client client) {
        System.out.println("Editar cliente con documento: " + document);
        try {
            if (!this.client.existByDocument(document)) {
                throw new Error("No se encontró a ningún cliente con ese documento");
            }
            this.client.update(document, client);
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteClient(String document) {
        System.out.println("Eliminar cliente con documento: " + document);
        try {
            if (!this.client.existByDocument(document)) {
                throw new Error("No se encontró a ningún cliente con ese documento");
            }
            this.client.delete(document);
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel listClients() {

        final String columnHeaders[] = {"Document", "Name", "Phone", "Email", "", ""};

        final DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnHeaders);

        try {
            final List<Client> clients = this.client.findAllClients();

            clients.forEach(it -> {
                model.addRow(new Object[]{
                    it.getDocument(),
                    it.getName(),
                    it.getPhone(),
                    it.getEmail(),
                    "Edit",
                    "Delete",});
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }

    public DefaultTableModel listClients(List<Client> clients) {
        final String columnHeaders[] = {"Document", "Name", "Phone", "Email", "", ""};

        final DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnHeaders);

        clients.forEach(it -> {
            model.addRow(new Object[]{
                it.getDocument(),
                it.getName(),
                it.getPhone(),
                it.getEmail(),
                "Edit",
                "Delete",});
        });

        return model;
    }

    public Client findClientByDocument(String document) {
        try {
            if (!this.client.existByDocument(document)) {
                throw new Error("No se encontró a ningún cliente con ese documento");
            }

            final Client clientFounded = this.client.findClientByDocument(document);

            return clientFounded;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }

    public List<Client> findClientsByDocument(String document) {
        try {
            final List<Client> clients = this.client.findClientsByDocument(document);

            return clients;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }
}
