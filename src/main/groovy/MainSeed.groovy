
folder('Demo') {
    displayName('Demo')
    description('Demo Folder')
}

multiBranchJobs = [
        [
                name: 'springboot-sample-app.git',
                url: 'https://github.com/Continuous-X/springboot-sample-app.git'
        ]
]

multiBranchJobs.each { job ->
    multibranchPipelineJob(job.name) {
        displayName job.name
        branchSources {
            git {
                id(job.name)
                remote(job.url)
                includes('*')
            }
        }
        orphanedItemStrategy {
            discardOldItems {
                numToKeep(20)
            }
        }
    }
}