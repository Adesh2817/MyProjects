document.addEventListener("DOMContentLoaded", function() {
    const question =[
        {
            question:"Which is not an aquatic animal?" ,
            answers: [
                { text:"Shark", correct: false},
                { text:"Whale", correct: false},
                { text:"Lion", correct: true},
                { text:"Crab", correct: false},
            ] 
        },
        {
            question:"What is the chemical symbol for water??" ,
            answers: [
                { text:"H2O", correct: true},
                { text:"CO2", correct: false},
                { text:"CO2", correct: false},
                { text:"CH4", correct: false},
            ] 
        },
        {
            question:"What is the tallest mountain in the world?" ,
            answers: [
                { text:"Mount McKinley (Denali)", correct: false},
                { text:"Kilimanjaro", correct: false},
                { text:"K2", correct: false},
                { text:" Mount Everest", correct: true},
            ] 
        },
        {
            question:"Which planet is known as the (Red Planet)?" ,
            answers: [
                { text:"Jupiter", correct: false},
                { text:"Mars", correct: true},
                { text:"Earth", correct: false},
                { text:"Pluto", correct: false},
            ] 
        }
    ];
    
    const questionElement = document.getElementById("question");
    const answerElement = document.getElementById("answer-button");
    const nextElement = document.getElementById("nxt-btn");
    
    let currentQuestionIndex = 0;
    let score = 0;
    
    function startQuiz(){
        currentQuestionIndex =0;
        score= 0;
        nextElement.innerHTML = "Next";
        showQuestion();
    }
    
    function showQuestion(){
        resetState();
        let currentQuestion = question[currentQuestionIndex];
        let questionNo = currentQuestionIndex + 1;
        questionElement.innerHTML = questionNo + " " + currentQuestion.question;
    
        currentQuestion.answers.forEach(answer => {
            const button = document.createElement("button");
            button.innerHTML = answer.text;
            button.classList.add("btn");
            answerElement.appendChild(button);
            if(answer.correct){
                button.dataset.correct = answer.correct;
            }
            button.addEventListener("click",selectAnswer)
        });
    }

    function resetState(){
        nextElement.style.display = "none";
        while(answerElement.firstChild){
            answerElement.removeChild(answerElement.firstChild);
        }
    }
    
    function selectAnswer(e){
        const selectedBtn = e.target;
        const isCorrect = selectedBtn.dataset.correct === "true";
        if(isCorrect){
            selectedBtn.classList.add("correct");
            score++;
        }else{
            selectedBtn.classList.add("incorrect");
        }
        Array.from(answerElement.children).forEach(button =>{
            if(button.dataset.correct === "true")
            {
                button.classList.add("correct");
            }
            button.disabled = true;
        }
            );
            nextElement.style.display = "block";
    }

    function showScore(){
        resetState();
        questionElement.innerHTML = `Your score is ${score} out of ${question.length} !`;
        nextElement.innerHTML = "Play Again";
        nextElement.style.display = "block";
    }

    function handleNextButton(){
        currentQuestionIndex++;
        if(currentQuestionIndex < question.length){
            showQuestion();
        }else{
            showScore();
        }
    }

    nextElement.addEventListener("click", ()=>{
       if(currentQuestionIndex < question.length){
        handleNextButton();
       }else{
        startQuiz();
       }
    })



    startQuiz();
});
