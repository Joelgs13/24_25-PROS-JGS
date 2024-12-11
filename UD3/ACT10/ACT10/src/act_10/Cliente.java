            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            Tenista receivedTenista = (Tenista) objectInputStream.readObject();

            // Display the modified object
            System.out.println("Received the object: " + receivedTenista.getApellido() + " " + receivedTenista.getAltura());
            System.out.println("Client terminated");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
