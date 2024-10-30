# -AI-Powered-Multi-Feature-Application-with-Image-Generation-Chat-Bot-and-Recipe-Suggestions

Overview
This is a full-stack application built with React for the frontend and Spring Boot for the backend, integrated with Spring AI for OpenAPI connections. The application provides three main features: image generation, chatting with a bot, and recipe generation, offering a versatile platform for users to interact with AI.

Features
Image Generation:

Utilize Spring AI's method call with an image prompt to generate images from the API.
Adjustable parameters such as quality, height, and width to customize the generated images.
Chatbot Interaction:

Users can enter a single prompt to receive replies from the AI chatbot, allowing for engaging conversations.
Recipe Generation:

Users can input details such as ingredients, cuisine, and dietary restrictions to receive personalized recipes.
Recipe output includes a title, list of ingredients, and cooking instructions.
Technical Details
Frontend: Developed using React for a responsive and dynamic user interface.
Backend: Built with Spring Boot, ensuring robust and scalable server-side logic.
OpenAPI Integration: Uses Spring AI to interact with external APIs for image generation and chat functionality.
Configuration
CORS Handling: Implemented a separate configuration file to handle CORS errors, enabling access across different ports.
Dynamic Prompting: The application allows for changing prompts to retrieve various types of responses, including different models (e.g., DALL-E 2 or 3) and settings like image quality and maximum tokens.
Installation
To set up the project locally, follow these steps:

Clone the Repository:

bash
Copy code
git clone https://github.com/your-username/your-repository-name.git
Navigate to the Project Directory:

bash
Copy code
cd your-repository-name
Install Dependencies:

For the frontend:
bash
Copy code
cd frontend
npm install
For the backend:
bash
Copy code
cd backend
./mvnw install
Run the Application:

Start the backend server:
bash
Copy code
cd backend
./mvnw spring-boot:run
Start the frontend application:
bash
Copy code
cd frontend
npm start
Usage
Open your web browser and navigate to http://localhost:3000 to access the application.
Explore the different features: generate images, chat with the bot, and create recipes.
Contributing
Contributions are welcome! If you have suggestions for improvements or new features, please open an issue or submit a pull request.

License
This project is licensed under the MIT License.

Feel free to modify any sections to better fit your project specifics or personal style. Let me know if you need any additional information or sections!






