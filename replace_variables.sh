#!/bin/bash

# Define a function to replace variables in a file
replace_variables() {
    file="$1"

    # Find all variables in the file
    variables=$(grep -o -E '#{[A-Za-z0-9_]+}#' "$file")

    # Loop through each variable and replace it with the corresponding environment variable value
    for variable in $variables; do
        # Remove the leading and trailing hash symbols
        var_name=${variable#"#{"}
        var_name=${var_name%"}#"}

        # Get the environment variable value
        var_value="${!var_name}"

        if [[ -z "$var_value" ]]; then
            # Handle the case where the environment variable is not found
            echo "Warning: Variable '${var_name}' not found in environment variables."
            continue
        fi

        # Escape special characters in the variable value
        var_value_escaped=$(echo "$var_value" | sed 's/[\&/]/\\&/g')

        # Replace the variable with the environment variable value
        sed -i "s|${variable}|${var_value_escaped}|g" "$file"
    done
}

# Specify the directory path as the current working directory
directory_path="$PWD"

# Find and replace variables in all files within the directory and its subdirectories
find "$directory_path" -type f -print0 | while IFS= read -r -d '' file; do
    replace_variables "$file"
done
