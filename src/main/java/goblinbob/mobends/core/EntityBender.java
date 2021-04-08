package goblinbob.mobends.core;

import goblinbob.mobends.core.exceptions.InvalidMutationException;
import goblinbob.mobends.core.mutation.PuppeteerException;

public class EntityBender<C>
{
    private IPuppeteerRepository<C> puppeteerRepository;

    protected final String key;
    protected final String unlocalizedName;
    public final Class<?> entityClass;
    private final IBenderResources benderResources;

    private boolean animate = true;

    public EntityBender(IPuppeteerRepository<C> puppeteerRepository, String key, String unlocalizedName, Class<?> entityClass, IBenderResources benderResources)
    {
        this.puppeteerRepository = puppeteerRepository;

        if (entityClass == null)
            throw new NullPointerException("The entity class cannot be null.");

        this.key = key;
        this.unlocalizedName = unlocalizedName;
        this.entityClass = entityClass;
        this.benderResources = benderResources;
    }

    public boolean isAnimated()
    {
        return animate;
    }

    public void setAnimate(boolean animate)
    {
        this.animate = animate;
    }

    public IBenderResources getBenderResources()
    {
        return benderResources;
    }

    /**
     * This function is to be called each time before rendering a mutated entity.
     * It animates, and if it wasn't done prior, mutates the entity model.
     */
    public void beforeRender(C context) throws PuppeteerException, InvalidMutationException
    {
        if (this.animate)
        {
            IPuppeteer<C> puppeteer = puppeteerRepository.getOrCreatePuppeteer(context, this);

            if (puppeteer != null)
            {
                puppeteer.perform(context);
                puppeteer.beforeRender(context);
            }
        }
        else
        {
            puppeteerRepository.disposePuppeteer(context, this);
        }
    }
}
