package com.pivotstir1.gogradle.tasks

import com.pivotstir1.gogradle.GoPlugin
import com.pivotstir1.gogradle.GradleSupport
import com.pivotstir1.gogradle.taskName
import org.gradle.api.Project

class GoSwagConfig(
        val project: Project
)

@GradleSupport
class GoSwag : AbstractGoTask<GoSwagConfig>(GoSwagConfig::class) {

    init {
        group = GoPlugin.NAME
        description = "Generate Swagger files for Gin project, supported by github.com/swaggo/gin-swagger"

        dependsOn(taskName(GoDep::class))
    }

    override fun run() {
        super.run()

        exec("swag init") {
            it.environment.putAll(this.goEnvs(it.environment))
        }
    }
}