import { injectable, inject } from 'inversify';
import { BaseLanguageClientContribution, Workspace, Languages, LanguageClientFactory } from '@theia/languages/lib/browser';
import {
    SPRING_BOOT_SERVER_ID,
    SPRING_BOOT_SERVER_NAME,
    BOOT_PROPERTIES_YAML_LANGUAGE_ID,
    BOOT_PROPERTIES_LANGUAGE_ID
} from '../common';
import { DocumentSelector } from '@theia/languages/lib/common';
import { JAVA_LANGUAGE_ID } from '@theia/java/lib/common';
import { HighlightService} from './highlight-service';
import { ClasspathService } from './classpath-service';

@injectable()
export class SpringBootClientContribution extends BaseLanguageClientContribution {

    readonly id = SPRING_BOOT_SERVER_ID;
    readonly name = SPRING_BOOT_SERVER_NAME;

    constructor(
        @inject(Workspace) protected readonly workspace: Workspace,
        @inject(Languages) protected readonly languages: Languages,
        @inject(LanguageClientFactory) protected readonly languageClientFactory: LanguageClientFactory,
        @inject(HighlightService) protected readonly highlightService: HighlightService,
        @inject(ClasspathService) protected readonly classpathService: ClasspathService
    ) {
        super(workspace, languages, languageClientFactory);
        this.languageClient.then(client => {
            this.highlightService.attach(client);
            // this.classpathService.attach(client);
        });
    }

    protected get documentSelector(): DocumentSelector | undefined {
        return [JAVA_LANGUAGE_ID, BOOT_PROPERTIES_YAML_LANGUAGE_ID, BOOT_PROPERTIES_LANGUAGE_ID];
    }

    protected get globPatterns() {
        return [
            '**/*.java',
            '**/application*.yml',
            '**/bootstrap*.yml',
            '**/application*.properties',
            '**/bootstrap*.properties'
        ];
    }

}
