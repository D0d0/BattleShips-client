package game;

import org.json.JSONObject;

class Game {

    private WebSocket ws = new WebSocket(this);

    Game() {

        ws.connectToWebSocket();
    }

    private void sendMessage(String type, JSONObject jsonObject) {

        JSONObject obj = new JSONObject();

        obj.put("messageType", type);
        obj.put("message", jsonObject);

        ws.sendMessage(obj.toString());
    }

    void processMessage(String message) {
        System.out.println(message);
        JSONObject jsonObject = new JSONObject(message);
        JSONObject jsonData = jsonObject.getJSONObject("data");
        String messageType = jsonData.getString("messageType");
        Object messageObject = jsonData.get("message");
        switch (messageType) {
            case "version":

                getVersionHandler(messageObject);
                break;
            case "allGames":

                allGamesChangedHandler(messageObject);
                break;
            case "preparationStarted":

                preparationStartedHandler(messageObject);
                break;
            case "disconnect":

                disconnectHandler(messageObject);
                break;
        }
    }

    private void disconnectHandler(Object messageObject) {

        System.out.println(messageObject);
    }

    void getVersion() {

        sendMessage("version", null);
    }

    private void getVersionHandler(Object response) {

        System.out.println(response);
    }

    void createGame() {

        sendMessage("createGame", null);
    }

    private void allGamesChangedHandler(Object response) {

        System.out.println(response);
    }

    void joinGame(String gameKey) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gameKey", gameKey);

        sendMessage("joinGame", jsonObject);
    }

    private void preparationStartedHandler(Object messageObject) {

        System.out.println(messageObject);
    }

    private void addShip(int type, String playerKey, String gameKey, int x, int y) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gameKey", gameKey);
        jsonObject.put("playerKey", playerKey);
        jsonObject.put("type", type);
        jsonObject.put("x", x);
        jsonObject.put("y", y);

        sendMessage("addShip", jsonObject);
    }

    private void leaveGame(String gameKey, String playerKey) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gameKey", gameKey);
        jsonObject.put("playerKey", playerKey);

        sendMessage("leaveGame", jsonObject);
    }
}
