def call(Map config = [:]) {
    // Check if name and dayOfWeek are provided
    if (!config.name || !config.dayOfWeek) {
        sh 'echo Error: Name and dayOfWeek are required.'
        return
    }

    // Validate dayOfWeek
    def validDays = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
    if (!validDays.contains(config.dayOfWeek)) {
        sh "echo Error: Invalid dayOfWeek: ${config.dayOfWeek}. Must be one of: ${validDays.join(', ')}."
        return
    }

    // Validate name
    if (!config.name?.trim()) {
        sh 'echo Error: Name cannot be empty.'
        return
    }

    sh "echo Hello ${config.name}. Today is ${config.dayOfWeek}."
}
