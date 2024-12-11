var chatPage = document.querySelector('#chat-page');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');

var stompClient = null;
var currentUser = null;
var currentGroup = null

function connect(uID, gID) {
currentUser = uID;
currentGroup = gID;
    if(currentUser != null && currentGroup != null) {
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect(currentUser, onConnected);
    }
}


function onConnected() {
    loadPreviousMessages();
    stompClient.subscribe('/topic/public', appendMessage);

    stompClient.send("/chat.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )
}

function loadPreviousMessages(){
previousMessages.forEach((message) =>appendMessage(message, true));
}


function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var chatMessage = {
            senderID: currentUser,
            groupID: currentGroup,
            message: messageInput.value,
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}




function appendMessage(payload, isPrevious) {
var message ;
if(isPrevious==true){
message=payload;
}
else{
message = JSON.parse(payload.body);
}


    var messageElement = document.createElement('li');

        messageElement.classList.add('chat-message');

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);


    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}

messageForm.addEventListener('submit', sendMessage, true)