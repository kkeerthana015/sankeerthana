const fs = require('fs');

// Decode a value from a given base to decimal (base 10)
function decodeValue(value, base) {
  return parseInt(value, base);
}

// Lagrange interpolation to find the polynomial at x=0 (constant term)
function lagrangeInterpolation(xValues, yValues, x) {
  let result = 0;

  for (let i = 0; i < xValues.length; i++) {
    let term = yValues[i];
    for (let j = 0; j < xValues.length; j++) {
      if (i !== j) {
        term *= (x - xValues[j]) / (xValues[i] - xValues[j]);
      }
    }
    result += term;
  }
  return result;
}

// Read and process the test case from the JSON file
function processTestCases(fileName) {
  fs.readFile(fileName, 'utf8', (err, data) => {
    if (err) {
      console.error('Error reading the JSON file:', err);
      return;
    }

    const testCases = JSON.parse(data);
    const xValues = [];
    const yValues = [];

    // Extract the values from the test case
    for (let key in testCases) {
      if (key !== 'keys') {
        const testCase = testCases[key];
        const decodedValue = decodeValue(testCase.value, testCase.base);

        xValues.push(Number(key));  // x is the key of the object
        yValues.push(decodedValue);  // y is the decoded value
      }
    }

    const constantC = lagrangeInterpolation(xValues, yValues, 0);
    console.log('Constant C:', constantC);
  });
}

// Process the first test case
processTestCases('testcase1.json');
// Process the second test case
processTestCases('testcase2.json');