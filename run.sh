#!/bin/bash

# GitHub User Activity - Compile and Run Script

echo "🔨 Compiling project..."
mvn clean compile

if [ $? -ne 0 ]; then
    echo "❌ Compilation failed!"
    exit 1
fi

echo "✅ Compilation successful!"
echo ""
echo "🚀 Running with username: ${1:-aposalik}"
echo ""

java -cp "target/classes:gson-2.10.1.jar" org.example.Main "${1:-aposalik}"
