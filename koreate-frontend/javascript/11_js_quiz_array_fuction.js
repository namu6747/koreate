// 4/7 11_js_quiz_array_fuction.js
function inputScore(arrays, size, subject){
    for(let i=0; i<size; i++){
        let score = prompt(subject+"과목에 점수를 입력해주세요!");
        arrays.push(parseInt(score));
        // arrays[i] = score;
        // score = parseInt(score);
        // arrays.push(parseInt(prompt(subject+"과목에 점수를 입력해주세요!")));
    }
    return arrays;
}

function maxScore(arrays){
    let max =  arrays[0];
    for(let score of arrays){
        if(score > max){
            max = score;
        }
    }
    return max;
}

function  minScore(arrays){
    let min = arrays[0];
    for(let index in arrays){
        if(min > arrays[index]){
            min = arrays[index];
        }
    }
    return min;
}

function totalValue(arrays){
    let sum = 0;
    for(let i=0; i<arrays.length; i++){
        sum += arrays[i];;
    }
    return sum;
}

function average(total, size){
    avg = total/size;
    return avg;
    }
